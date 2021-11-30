package overriding;

public class Child extends Parent {

	public void show() {
		;
	}

	public void dispaly() {

	}

	public static void main(String[] args) {
		Child c = new Child();
		c.show();
		// c.20add();
		// c.dispaly();
		c.add();
	}

	// cant overide static methods
	public static void add() {
		System.out.println("add - from Child()");
	}

}
