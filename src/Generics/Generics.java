package Generics;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.Number;
import java.lang.String;
import java.lang.Double;
import java.util.List;
import java.util.Iterator;

public class Generics {
    public static void main(String[] args) {
//        Person[] ps = new Person[] {
//                new Person("Bob", 61),
//                new Person("Alice", 88),
//                new Person("Lily", 75),
//        };
//        Arrays.sort(ps);
//        System.out.println(Arrays.toString(ps));
//        Pair<String, Integer> p = new Pair<>("test", 123);


//          Class<IntPair> clazz = IntPair.class;
//          Type t = clazz.getGenericSuperclass();
//          if(t instanceof ParameterizedType){
//              ParameterizedType pt = (ParameterizedType) t;
//              Type[] types = pt.getActualTypeArguments(); // 可能有多个泛型类型
//              Type firstType = types[0]; // 取第一个泛型类型
//              System.out.println(firstType);
//          }

//            Pair<Integer> p = new Pair<Integer>(123,456);
//            int n = add(p);
//            System.out.println(n);


//        Pair<Integer> p2 = new Pair<>(123, 456);
//
//        setSame(p2, 200);
//
//        System.out.println(p2.getFirst() + ", " + p2.getLast());

          List<String> list = new ArrayList<>();
          list.add("apple");
          list.add("pear");
          for (Iterator<String> it = list.iterator();it.hasNext();){
              String s = it.next();
              System.out.println(s);
          }



          String[] array = list.toArray(new String[list.size()]);

        for (String s:array){
            System.out.println(s);
        }

        Integer[] arr2 = {1,2,3,4,5,6,7};
        List<Integer> list2 = Arrays.asList(arr2);

}

    static int add(Pair<? extends Number> p){
        Number first = p.getFirst();
        Number last = p.getLast();
        return first.intValue() + last.intValue();

    }

    static void setSame(Pair<? super Integer> p, Integer n) {
        p.setFirst(n);
        p.setLast(n);
    }
}


class Person implements Comparable<Person>{
    String name;
    int score;
    Person(String name, int score) {
        this.name = name;
        this.score = score;
    }
    public String toString() {
        return this.name + "," + this.score;
    }
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }
}

//interface Comparable<T> {
//    /**
//     * 返回-1: 当前实例比参数o小
//     * 返回0: 当前实例与参数o相等
//     * 返回1: 当前实例比参数o大
//     */
//    int compareTo(T o);
//}

//class Pair<T, K> {
//    private T first;
//    private K last;
//    public Pair(T first, K last) {
//        this.first = first;
//        this.last = last;
//    }
//    public T getFirst() {return this.first;}
//    public K getLast() {return this.last; }
//}

class Pair<T> {
    private T first;
    private T last;
    public Pair(T first, T last){
        this.first = first;
        this.last = last;
    }
    public T getFirst(){
        return first;
    }
    public T getLast(){
        return last;
    }
    public void setFirst(T first) {
        this.first = first;
    }
    public void setLast(T last) {
        this.last = last;
    }
}

class IntPair extends Pair<Integer> {
    public IntPair(Integer first, Integer last){
        super(first, last);
    }
}