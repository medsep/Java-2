package InterfaceExample;

public class Child1 extends ParentsClass1 implements Parents1, Parents2 {

	@Override
	public void show() {
		// TODO Auto-generated method stub

		System.out.println("Child show");
	}

	public static void main(String[] args) {
		Parents1 c = new Child1();
		c.show();
	}
}
