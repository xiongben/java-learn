package errorLearn;
import java.io.UnsupportedEncodingException;
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

    public static void main(String[] args){
//         Logger logger = Logger.getGlobal();
//         logger.info("start process...");
//         logger.warning("memory is running out...");
//         logger.fine("ignored.");
//         logger.severe("process will be terminated...");
            Log log = LogFactory.getLog(ErrorLearn.class);
            log.info("start...");
            log.warn("end.");
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
}
