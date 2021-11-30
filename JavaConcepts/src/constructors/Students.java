package constructors;

/**
 * constructors same name as class name. initialize instance varaiables. modify
 * access modfiers
 * 
 * 
 * 3 types:default, parametrized, non-args
 *
 */
public class Students {

	public Students(int i) {
		System.out.println(i);
	}

	// String stName;
	// int rlNum;
	private String studentName;
	private int rollNum;

	public Students(String studentName, int rollNum) {
		// new Students();
		this(100); // constructor chaining
		this.studentName = studentName;
		this.rollNum = rollNum;

	}

	public static void main(String[] args) {

		Students st = new Students("Andi", 101);
		System.out.println(st.studentName);
		System.out.println(st.rollNum);
		// Test t = new Test();

		new Students("Robert", 007);

	}

}
