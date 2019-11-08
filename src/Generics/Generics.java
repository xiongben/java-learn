package Generics;
import java.util.*;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.Number;
import java.lang.String;
import java.lang.Double;
import java.util.HashMap;
import java.util.Map;

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

//          List<String> list = new ArrayList<>();
//          list.add("apple");
//          list.add("pear");
//          for (Iterator<String> it = list.iterator();it.hasNext();){
//              String s = it.next();
//              System.out.println(s);
//          }
//
//
//
//          String[] array = list.toArray(new String[list.size()]);
//
//        for (String s:array){
//            System.out.println(s);
//        }
//
//        Integer[] arr2 = {1,2,3,4,5,6,7};
//        List<Integer> list2 = Arrays.asList(arr2);
//
//        List<Integer> arr3 = Arrays.asList(1,2,3);
//        System.out.println(arr3.contains(2));
//        System.out.println(arr3.indexOf(1));

//        List<Person> list1 = Arrays.asList(
//                new Person("xiaoming",34),
//                new Person("xiaohong",94),
//                new Person("xiaoliu",84)
//        );
//
//        System.out.println(list1.contains(new Person("xiaohong",94)));

//         Student s = new Student("xiaoming",99);
//         Map<String, Student> map1 = new HashMap<>();
//         map1.put("xiaoming", s);
//        Student target = map1.get("xiaoming"); // 通过key查找并返回映射的Student实例
//        System.out.println(target == s); // true，同一个实例
//        System.out.println(target.score); // 99
//
//        Map<String, Integer> map2 = new HashMap<>();
//        map2.put("apple", 123);
//        map2.put("pear", 456);
//        map2.put("banana", 789);
//        for(String key: map2.keySet()){
//            Integer value = map2.get(key);
//            System.out.println(key + " = " + value);
//        }
//
//        Map<String , Integer> map3 = new TreeMap<>();
//        map3.put("orange",1);
//        map3.put("apple",2);
//        map3.put("pear",3);
//        for(String key: map3.keySet()){
//            System.out.println(key);
//        }

//          Queue<String> q = new LinkedList<>();
//        q.offer("apple");
//        q.offer("pear");
//        q.offer("banana");
//        System.out.println(q.poll()); // apple
//        System.out.println(q.poll()); // pear
//        System.out.println(q.poll()); // banana
//        System.out.println(q.poll()); // null,因为队列是空的


//        Queue<User> q = new PriorityQueue<>(new UserComparator());
//        // 添加3个元素到队列:
//        q.offer(new User("Bob", "A1"));
//        q.offer(new User("Alice", "A2"));
//        q.offer(new User("Boss", "V1"));
//        System.out.println(q.poll()); // Boss/V1
//        System.out.println(q.poll()); // Bob/A1
//        System.out.println(q.poll()); // Alice/A2
//        System.out.println(q.poll()); // null,因为队列为空

          

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
    public boolean equals(Object o){  //复写equals方法
        if(o instanceof Person){
            Person p = (Person) o;
            return Objects.equals(this.name,p.name) && this.score == p.score;
        }
        return false;
    }
}


class User {
    public final String name;
    public final String number;

    public User(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String toString() {
        return name + "/" + number;
    }
}

class UserComparator implements Comparator<User>{
    public int compare( User u1, User u2){
        if(u1.number.charAt(0) == u2.number.charAt(0)){
            return u1.number.compareTo(u2.number);
        }
        if(u1.number.charAt(0) == 'V'){
            return -1;
        }else{
            return 1;
        }
    }
}

class Student {
    public String name;
    public int score;
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
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