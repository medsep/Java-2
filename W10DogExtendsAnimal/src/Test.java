
public class Test {

	class A {
		public void display() {
			System.out.print("One");
		}
	}

	class B extends A {
		@Override
		public void display() {
			System.out.print("Two");
		}
	}

	public class C {
		public void main(String args[]) {
			B screen = new B();
			screen.display();
		}
	}

}
