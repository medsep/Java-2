package train1.com.fx1;

public class Student2 {

	int age;
	String name;
	static int NoOfStudents = 0;

	Student2() {
		NoOfStudents++;
	}

	public static int getNoOfStudents() {
		return NoOfStudents;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
