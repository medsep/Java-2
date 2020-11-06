import java.util.Random;

public class Arrays {

	int[] counts = new int[4];
	// double[] values = new double[size];

	public static void printArray(int[] a) {
		System.out.print("{" + a[0]);
		for (int i = 1; i < a.length; i++) {
			System.out.print(", " + a[i]);
		}
		System.out.println("}");
	}

	public static int[] randomArray(int size) {
		Random random = new Random();
		int[] a = new int[size];
		for (int i = 0; i < a.length; i++) {
			a[i] = random.nextInt(100);
		}
		return a;
	}

	public static int search(double[] a, double target) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == target) {
				return i;
			}
		}
		return -1;
	}

	public static double sum(double[] a) {
		double total = 0.0;
		for (int i = 0; i < a.length; i++) {
			total += a[i];
		}
		return total;
	}

	public static int[] randomArray1(int size) {
		Random random = new Random();
		int[] a = new int[size];
		for (int i = 0; i < a.length; i++) {
			a[i] = random.nextInt(100);
		}
		return a;
	}

	public static int inRange(int[] a, int low, int high) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] >= low && a[i] < high) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {

		int numValues = 8;
		int[] array = randomArray(numValues);
		printArray(array);
		int[] a = { 1, 2, 3, 4 };
		printArray(a);
		double[] k = { 2.2, 3.3, 6, 8.6, 9.6, 5.5 };
		System.out.println(sum(k));
		System.out.println(search(k, 9.6));
		int numValues1 = 8;
		int[] array1 = randomArray1(numValues1);
		printArray(array1);

		int[] scores = randomArray(30);
		int a1 = inRange(scores, 90, 100);
		System.out.println("a1: " + a1);
		int b = inRange(scores, 80, 90);
		System.out.println("b: " + b);
		int c = inRange(scores, 70, 80);
		System.out.println("c: " + c);
		int d = inRange(scores, 60, 70);
		System.out.println("d: " + d);
		int f = inRange(scores, 0, 60);
		System.out.println("f: " + f);

	}

	}

}
