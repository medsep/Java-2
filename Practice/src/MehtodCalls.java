
public class MehtodCalls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MehtodCalls m1 = new MehtodCalls();
		m1.go1();

		System.out.println("after calling 2");
		// m1.go1();
		// m1.go2();

		// go2();
	}

	public void go() {
		System.out.println("Inside method");
		go2();
		go1();
		System.out.println("after calling");
	}

	public void go1() {
		System.out.println("Inside method1");
		go2();
		System.out.println("after calling 3");
	}

	public void go2() {
		System.out.println("Inside method2");
	}

}
