package com.xb.demo1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATMSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();
        while (true) {
            System.out.println("=====ATM系统初始化=======");
            System.out.println("1,账户登录");
            System.out.println("2,账户开户");


            System.out.println("请选择你的操作");
            int command = sc.nextInt();

            switch (command){
                case 1:
                    // user login
                    login(accounts, sc);
                    break;
                case 2:
                    //user register
                    register(accounts, sc);
                    break;
                default:
                    System.out.println("你输入的命令不存在！");

            }
        }
    }

    /**
     * account login function
     * @param accounts
     * @param sc
     */
    private static void login(ArrayList<Account> accounts, Scanner sc) {
        System.out.println("============Login system===========");
        if(accounts.size() == 0) {
            System.out.println("there is no account!");
            return;
        }
        while (true) {
            System.out.println("Please enter account number:");
            String cardId = sc.next();
            Account acc = getAccountByCardId(cardId, accounts);
            if(acc != null) {
                while (true) {
                    System.out.println("Please enter password:");
                    String pwd = sc.next();
                    if(acc.getPassWord().equals(pwd)) {
                        System.out.println("Success!" + acc.getUserName() + " enter the system!");
                        showUserCommond(sc, acc);
                        return;
                    } else {
                        System.out.println("Your password is error!");
                    }
                }
            } else {
                System.out.println("your account is not exit!");
            }
        }
    }

    private static void showUserCommond(Scanner sc, Account acc) {
        while (true) {
            System.out.println("============ User Main Page ============");
            System.out.println("1,查询账户");
            System.out.println("2,存款");
            System.out.println("3，取款");
            System.out.println("4，转账");
            System.out.println("5，修改密码");
            System.out.println("6，退出");
            System.out.println("7，注销账户");
            System.out.println("Choose Operation Type:");
            int commond = sc.nextInt();
            switch (commond) {
                case 1:
                    showAccount(acc);
                    break;
                case 2:
                    // 存款
                    depositMoney(acc, sc);
                    break;
                case 3:
                    // 取款
                    withDrawMoney(acc, sc);
                    break;
                case 4:
                    // 转账
                    break;
                case 5:
                    // 修改密码
                    break;
                case 6:
                    System.out.println("logout!!!");
                    return;
                case 7:
                    break;
                default:
                    System.out.println("Operation error!");
            }
        }
    }

    private static void withDrawMoney(Account acc, Scanner sc) {
        System.out.println("========取钱操作===========");
        if(acc.getMoney() < 100) {
            System.out.println("你账户余额不够100，无法取钱！");
            return;
        }
        while (true) {
            System.out.println("Enter the number of withdraw:");
            double money = sc.nextDouble();

            if (money > acc.getQuotaMoney()) {
                System.out.println("超出取款限额" + acc.getQuotaMoney());
            } else {
                if (money > acc.getMoney()) {
                    System.out.println("余额不足！你目前的余额是： " + acc.getMoney());
                } else {
                    System.out.println("取款成功！！！");
                    acc.setMoney(acc.getMoney() - money);
                    showAccount(acc);
                    return;
                }
            }
        }
    }

    /**
     * 存钱
     * @param acc
     * @param sc
     */
    private static void depositMoney(Account acc, Scanner sc) {
        System.out.println("========用户存钱操作=========");
        System.out.println("enter the money number: ");
        double money = sc.nextDouble();
        acc.setMoney(acc.getMoney() + money);
        System.out.println("success! your Account info: ");
        showAccount(acc);
    }

    /**
     * 展示账户信息
     * @param acc
     */
    private static void showAccount(Account acc) {
        System.out.println("======== User Account Info Detail ========");
        System.out.println("Card number: " + acc.getCardId());
        System.out.println("User name: " + acc.getUserName());
        System.out.println("Money: " + acc.getMoney());
        System.out.println("User Limit: " + acc.getQuotaMoney());
    }

    /**
     * user register account
     * @param accounts
     */
    private static void register(ArrayList<Account> accounts, Scanner sc) {
        System.out.println("==========系统开户操作===========");
        Account account = new Account();
        System.out.println("enter user name:");
        String userName = sc.next();
        account.setUserName(userName);

        while (true) {
            System.out.println("enter user password");
            String pwd = sc.next();
            System.out.println("enter user password again");
            String okPwd = sc.next();
            if (okPwd.equals(pwd)) {
                account.setPassWord(pwd);
                break;
            } else {
                System.out.println("password is not correct!");
            }
        }

        System.out.println("enter account limit:");
        double moneyLimit = sc.nextDouble();
        account.setQuotaMoney(moneyLimit);

        // create account number
        String cardId = getRandomCardId(accounts);
        account.setCardId(cardId);

        accounts.add(account);
        System.out.println("create card success!" + userName + ",card number is :" + cardId);
    }

    /**
     * create account number
     * @return
     */
    private static String getRandomCardId(ArrayList<Account> accounts) {
        Random r = new Random();
        while (true) {
            String cardId = "";
            for(int i = 0; i < 8; i++) {
                cardId += r.nextInt(10);
            }
            Account acc = getAccountByCardId(cardId, accounts);
            if(acc == null) {
                return cardId;
            }
        }
    }

    public static Account getAccountByCardId(String cardId, ArrayList<Account> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            Account acc = accounts.get(i);
            if(acc.getCardId().equals(cardId)){
                return acc;
            }
        }
        return null;
    }

}
