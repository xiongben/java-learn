
import java.beans.*;

public class Hello {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   Man man = new Man();
//         BeanInfo info = Introspector.getBeanInfo(Man.class);

		System.out.println("Today is:" + Weekday.MON);
	}
}


class Man {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

enum Weekday {
	MON(1,"星期一"),TUE(2,"星期二");
	public final int dayValue;
	private final String chinese;
  private Weekday(int dayValue,String chinese) {
  	this.dayValue = dayValue;
  	this.chinese = chinese;
  }
  @Override
	public String toString(){
  	 return this.chinese;
  }
}
