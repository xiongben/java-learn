package errorLearn;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ErrorLearn {
//    public static void main(String[] args){
//        byte[] bs = toGBK("中文");
//        System.out.println("Today is:66666");
//    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//         Logger logger = Logger.getGlobal();
//         logger.info("start process...");
//         logger.warning("memory is running out...");
//         logger.fine("ignored.");
//         logger.severe("process will be terminated...");
//            Log log = LogFactory.getLog(ErrorLearn.class);
//            log.info("start...");
//            log.warn("end.");
//        printClassInfo("".getClass());
//        printClassInfo(String[].class);
//        printClassInfo(int.class);

//          Class youngClass = YoungMan.class;
//          System.out.println(youngClass.getField("age"));
//          System.out.println(youngClass.getField("name"));
//          System.out.println(youngClass.getDeclaredField("num"));

          Object M = new Man("xiao ming");
          Class c = M.getClass();
          Field f = c.getDeclaredField("name");
          f.setAccessible(true);
          Object value = f.get(M);
          System.out.println(value);
    }

    static  byte[] toGBK(String s){
        try {
            return s.getBytes("GBK");
        }catch (UnsupportedEncodingException e){
            System.out.println(e);
            return s.getBytes();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    static void process1(){
        try {
            process2();
        }catch (NullPointerException e){
            throw new IllegalArgumentException(e);
        }
    }

    static void process2(){
        throw new NullPointerException();
    }

    static void printClassInfo(Class cls) {
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());
    }
}

class Man{
    private String name;
    public Man(){

    }
    public Man(String name){
        this.name = name;
    }
}
class YoungMan extends Man{
    public int age;
    private  int num;

    public YoungMan(){
        super();
    }
}