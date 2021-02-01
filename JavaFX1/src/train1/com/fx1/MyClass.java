package train1.com.fx1;

public class MyClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student Andy = new Student();
		Andy.setAge(25);
		Andy.setId(19846546);
		Andy.setName("Andrew Wilson");

		System.out.println(Andy.getName() + " is " + Andy.getAge() + "  id is " + Andy.getId());

		Student Mark = new Student();
		Mark.setAge(24);
		Mark.setId(19846666);
		Mark.setName("Mark Rock");

		System.out.println(Mark.getName() + " is " + Mark.getAge() + "  id is " + Mark.getId());

	}

}
