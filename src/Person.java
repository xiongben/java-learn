public class Person {
    protected String name;
    protected int age;
    public Person(String name,int age) {
        this.name = name;
        this.age = age;
    }
    public Person() {

    }
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void run(){
        System.out.println("person run");
    }
}

