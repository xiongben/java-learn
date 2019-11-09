package testLearn;

public class TestLearn {
//    public static void main(String[] args){
//        System.out.println("uuuuuu");
//    }
    public static long fact(long n) {
        long r = 1;
        for (long i = 1; i <= n; i++) {
            r = r * i;
        }
        return r;
    }
}
