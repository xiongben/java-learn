package errorLearn;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Constructor;
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

    public static void main(String[] args) throws Exception {
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

//          Object M = new Man("xiao ming");
//          Class c = M.getClass();
//          Field f = c.getDeclaredField("name");
//          f.setAccessible(true);
//          Object value = f.get(M);
//          System.out.println(value);

//        Man man1 = new Man();
//        Constructor consl = Integer.class.getConstructor(int.class);
//        Integer n1 = (Integer) consl.newInstance(123);
//        System.out.println(Man.class);
//        System.out.println(man1.getClass());

//        Class i = Integer.class;
//        Class n = i.getSuperclass();
//        System.out.println(n);
//        Class o = n.getSuperclass();
//        System.out.println(o);
//        System.out.println(o.getSuperclass());

//        Class s = Integer.class.getSuperclass();
//        Class[] is = s.getInterfaces();
//        for (Class i : is) {
//            System.out.println(i);
//        }

         InvocationHandler handler = new InvocationHandler() {
             @Override
             public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                 System.out.println(method);
                 if(method.getName().equals("morning")) {
                     System.out.println("Good morning, " + args[0]);
                 }
                 return null;
             }
         };
         Hello hello = (Hello) Proxy.newProxyInstance(
                 Hello.class.getClassLoader(),
                 new Class[]{Hello.class},
                 handler
         );
         hello.morning("Bob");
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

interface Hello {
    void morning(String name);
}