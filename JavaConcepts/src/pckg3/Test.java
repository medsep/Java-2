package pckg3;

public class Test {

	public int publicVariable = 10;
	private int privateVariable = 20;
	protected int protectedVaraible = 30;
	int defaultvariable = 40;

	public static void main(String[] args) {
		Test obj = new Test();

		System.out.println(obj.publicVariable);
		System.out.println(obj.privateVariable);
		System.out.println(obj.protectedVaraible);
		System.out.println(obj.defaultvariable);

	}

}
