
public class Test {

	int k;

	public void dispaly() {

	}

	public int view(int j, boolean ne, float k, String t) {
		return j;

	}

	private boolean yes() {
		return !false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// for (int i = 0; i <= 100000; i++) {
		// jabbertnew Test();
		// System.out.println(i);
		// }

		// intilization

		int i = 1234;
		float f = 1.234555555555555555555555555555555555555f;
		long l = 1024564564545454l;
		double d = 2.225555555555555555555555555555555555555;
		boolean b = true;
		char c = 'a';
		String s = "abcdef";

		Test t = new Test();
		System.out.println(t);

		t = null;

		Test t1 = t;

		Home h = new Home();
		h.i++;

		Home h1 = new Home();
		h1.i++;

		Home h2 = new Home();
		System.out.println(h2.i);

		// new Test();

		Test tt;

		String xyz = "AbCdefghjahjMn";

		String s1 = "abjb";
		String s2 = "hjsdhjh";
		String s3 = "djkjs";
		String s4 = s1 + s2 + s3;
		int s5 = 55;
		int s6 = 88;

		System.out.println(s4);
		System.out.println(s1 + s2 + s3);
		System.out.println("hi" + "how" + (s5 + s6) + "r" + "u");
		System.out.println(!b);
		System.out.println(34 <= 55);
		System.out.println(true && !false);
		System.out.println((234 == 125) && (10 == 10));

		System.out.println(true || !false);
		System.out.println((234 == 125) || (10 == 10));

		/*
		 * urnary operators binary oprators ternary operators
		 */

		Test t1t = new Test();
		t1t.view(s5, true, 33.5555f, s2);
		t1t.yes();

		Home calc = new Home();
		int p = calc.adition(15, 50);
		System.out.println(p);

	}

}
