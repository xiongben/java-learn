package com.xb.run;

import com.xb.bean.Business;
import com.xb.bean.Customer;
import com.xb.bean.Movie;
import com.xb.bean.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MovieSystem {
    public static final List<User> ALL_USERS = new ArrayList<>();

    public static final Map<Business, List<Movie>> ALL_MOVIES = new HashMap<>();

    public static User loginUser;

    public static final Scanner SYS_SC = new Scanner(System.in);
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    /**
     3、准备一些测试数据
     */
    static {
        Customer c = new Customer();
        c.setLoginName("zyf888");
        c.setPassWord("123456");
        c.setUserName("黑马刘德华");
        c.setSex('男');
        c.setMoney(10000);
        c.setPhone("110110");
        ALL_USERS.add(c);

        Customer c1 = new Customer();
        c1.setLoginName("gzl888");
        c1.setPassWord("123456");
        c1.setUserName("黑马关之琳");
        c1.setSex('女');
        c1.setMoney(2000);
        c1.setPhone("111111");
        ALL_USERS.add(c1);

        Business b = new Business();
        b.setLoginName("baozugong888");
        b.setPassWord("123456");
        b.setUserName("黑马包租公");
        b.setMoney(0);
        b.setSex('男');
        b.setPhone("110110");
        b.setAddress("火星6号2B二层");
        b.setShopName("甜甜圈国际影城");
        ALL_USERS.add(b);
        // 注意，商家一定需要加入到店铺排片信息中去
        List<Movie> movies = new ArrayList<>();
        ALL_MOVIES.put(b , movies); // b = []

        Business b2 = new Business();
        b2.setLoginName("baozupo888");
        b2.setPassWord("123456");
        b2.setUserName("黑马包租婆");
        b2.setMoney(0);
        b2.setSex('女');
        b2.setPhone("110110");
        b2.setAddress("火星8号8B八层");
        b2.setShopName("巧克力国际影城");
        ALL_USERS.add(b2);
        // 注意，商家一定需要加入到店铺排片信息中去
        List<Movie> movies3 = new ArrayList<>();
        ALL_MOVIES.put(b2 , movies3); // b2 = []
    }

    public static void main(String[] args) {
       showMain();
    }

    private static void showMain() {
        System.out.println("==============电影院首页===============");
        System.out.println("1, 登录");
        System.out.println("2, 用户注册");
        System.out.println("3, 商家注册");
        System.out.println("4, 请输入命令：");
        while (true) {
            String command = SYS_SC.nextLine();
            switch (command) {
                case "1":
                    login();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                default:
                    System.out.println("命令有误，请重新输入！");
            }
        }
    }

    private static void login() {
        while (true) {
            System.out.println("=请你输入登录名称：");
            String loginName = SYS_SC.nextLine();
            System.out.println("请你输入登录密码：");
            String password = SYS_SC.nextLine();

            User u = getUserByLoginName(loginName);
            if(u != null) {
                if(u.getPassWord().equals(password)) {
                    loginUser = u;
                    if(u instanceof Customer) {
                        //普通用户
                        showCustomerMain();
                    } else {
                        //商户
                        showBusinessMain();
                    }
                    return;
                } else {
                    System.out.println("password error!");
                }
            } else {
                System.out.println("user login name error!again!");
            }
        }
    }

    private static void showBusinessMain() {
        while (true) {
            System.out.println("============黑马电影商家界面===================");
            System.out.println(loginUser.getUserName() + (loginUser.getSex()=='男'? "先生":"女士" + "欢迎您进入系统"));
            System.out.println("1、展示详情:");
            System.out.println("2、上架电影:");
            System.out.println("3、下架电影:");
            System.out.println("4、修改电影:");
            System.out.println("5、退出:");

            System.out.println("请输入您要操作的命令：");
            String command = SYS_SC.nextLine();
            switch (command){
                case "1":
                    // 展示全部排片信息
                    showBusinessInfos();
                    break;
                case "2":
                    // 上架电影信息
                    addMovie();
                    break;
                case "3":
                    // 下架电影信息
                    deleteMovie();
                    break;
                case "4":
                    // 修改电影信息
                    updateMovie();
                    break;
                case "5":
                    System.out.println(loginUser.getUserName() +"请您下次再来啊~~~");
                    return; // 干掉方法
                default:
                    System.out.println("不存在该命令！！");
                    break;
            }
        }
    }

    private static void updateMovie() {
        Business business = (Business) loginUser;
        List<Movie> movies = ALL_MOVIES.get(business);
        if(movies.size() == 0) {
            System.out.println("当前无片可以下架！");
            return;
        }
        while (true) {
            System.out.println("请你输入需要修改的电影名称：");
            String movieName = SYS_SC.nextLine();

            Movie movie = getMovieByName(movieName);
            if(movie != null) {
                System.out.println("请您输入修改后的片名：");
                String name  = SYS_SC.nextLine();
                System.out.println("请您输入修改后的主演：");
                String actor  = SYS_SC.nextLine();
                System.out.println("请您输入修改后的时长：");
                String time  = SYS_SC.nextLine();
                System.out.println("请您输入修改后的票价：");
                String price  = SYS_SC.nextLine();
                System.out.println("请您输入修改后的票数：");
                String totalNumber  = SYS_SC.nextLine(); // 200\n
                while (true) {
                    try {
                        System.out.println("请您输入修改后的影片放映时间：");
                        String stime  = SYS_SC.nextLine();
                        // public Movie(String name, String actor, double time, double price, int number, Date startTime)        // 封装成电影对象 ，加入集合movices中去
                        movie.setName(name);
                        movie.setActor(actor);
                        movie.setPrice(Double.valueOf(price));
                        movie.setTime(Double.valueOf(time));
                        movie.setNumber(Integer.valueOf(totalNumber));
                        movie.setStartTime(sdf.parse(stime));
                        System.out.println("已成功修改电影:" + movie.getName());
                        showBusinessInfos();
                        return; // 直接退出去
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("你的店铺没有上架该电影！");
                System.out.println("请问继续修改吗？y/n");
                String commond = SYS_SC.nextLine();
                switch (commond) {
                    case "y":
                        break;
                    default:
                        System.out.println("好的！");
                        return;
                }
            }
        }
    }

    private static void deleteMovie() {
        Business business = (Business) loginUser;
        List<Movie> movies = ALL_MOVIES.get(business);
        if(movies.size() == 0) {
            System.out.println("当前无片可以下架！");
            return;
        }
        while (true) {
            System.out.println("请你输入需要下架的电影名称：");
            String movieName = SYS_SC.nextLine();

            Movie movie = getMovieByName(movieName);
            if(movie != null) {
                movies.remove(movie);
                System.out.println("已成功下架电影:" + movie.getName());
                showBusinessInfos();
                return;
            } else {
                System.out.println("你的店铺没有上架该电影！");
                System.out.println("请问继续下架吗？y/n");
                String commond = SYS_SC.nextLine();
                switch (commond) {
                    case "y":
                        break;
                    default:
                        System.out.println("好的！");
                        return;
                }
            }
        }
    }

    public static Movie getMovieByName(String movieName) {
        Business business = (Business) loginUser;
        List<Movie> movies = ALL_MOVIES.get(business);
        for(Movie movie : movies) {
            if(movie.getName().contains(movieName)) {
                return movie;
            }
        }
        return null;
    }

    private static void addMovie() {
        System.out.println("================上架电影====================");
        // 根据商家对象(就是登录的用户loginUser)，作为Map集合的键 提取对应的值就是其排片信息 ：Map<Business , List<Movie>> ALL_MOVIES
        Business business = (Business) loginUser;
        List<Movie> movies = ALL_MOVIES.get(business);

        System.out.println("请您输入新片名：");
        String name  = SYS_SC.nextLine();
        System.out.println("请您输入主演：");
        String actor  = SYS_SC.nextLine();
        System.out.println("请您输入时长：");
        String time  = SYS_SC.nextLine();
        System.out.println("请您输入票价：");
        String price  = SYS_SC.nextLine();
        System.out.println("请您输入票数：");
        String totalNumber  = SYS_SC.nextLine(); // 200\n
        while (true) {
            try {
                System.out.println("请您输入影片放映时间：");
                String stime  = SYS_SC.nextLine();
                // public Movie(String name, String actor, double time, double price, int number, Date startTime)        // 封装成电影对象 ，加入集合movices中去
                Movie movie = new Movie(name, actor ,Double.valueOf(time) , Double.valueOf(price)
                        , Integer.valueOf(totalNumber) ,  sdf.parse(stime));
                movies.add(movie);
                System.out.println("您已经成功上架了：《" + movie.getName() + "》");
                return; // 直接退出去
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    private static void showBusinessInfos() {
        Business business = (Business) loginUser;
        System.out.println(business.getShopName() + "\t\t电话：" + business.getPhone() + "\t\t地址：" + business.getAddress());
        List<Movie> movies = ALL_MOVIES.get(business);
        if(movies.size() > 0) {
            System.out.println("片名\t\t\t主演\t\t时长\t\t评分\t\t票价\t\t余票数量\t\t放映时间");
            for (Movie movie : movies) {

                System.out.println(movie.getName()+"\t\t\t" + movie.getActor()+ "\t\t" + movie.getTime()
                        + "\t\t" + movie.getScore() + "\t\t" + movie.getPrice() + "\t\t" + movie.getNumber() + "\t\t"
                        +   sdf.format(movie.getStartTime()));
            }
        }else {
            System.out.println("您的店铺当前无片在放映~~~~");
        }
    }

    private static void showCustomerMain() {
        while (true) {
            System.out.println("============黑马电影客户界面===================");
            System.out.println(loginUser.getUserName() + (loginUser.getSex()=='男'? "先生":"女士" + "欢迎您进入系统" +
                    "\t余额：" + loginUser.getMoney()));
            System.out.println("请您选择要操作的功能：");
            System.out.println("1、展示全部影片信息功能:");
            System.out.println("2、根据电影名称查询电影信息:");
            System.out.println("3、评分功能:");
            System.out.println("4、购票功能:");
            System.out.println("5、退出系统:");
            System.out.println("请输入您要操作的命令：");
            String command = SYS_SC.nextLine();
            switch (command){
                case "1":
                    // 展示全部排片信息
                    showAllMovies();
                    break;
                case "2":
                    break;
                case "3":
                    // 评分功能
                    scoreMovie();
                    showAllMovies();
                    break;
                case "4":
                    // 购票功能
                    buyMovie();
                    break;
                case "5":
                    return; // 干掉方法
                default:
                    System.out.println("不存在该命令！！");
                    break;
            }
        }
    }

    private static void buyMovie() {
    }

    private static void scoreMovie() {
    }

    private static void showAllMovies() {
    }

    public static User getUserByLoginName(String loginName) {
        for(User user : ALL_USERS){
            if(user.getLoginName().equals(loginName)) {
                return user;
            }
        }
        return null;
    }
}
