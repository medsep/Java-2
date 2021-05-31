package Week2;

import java.util.Arrays;

public class RunningSumMain {

	public static void main(String[] input) {
		// TODO Auto-generated method stub

		runningSum SUM = new runningSum();
		int[] input1 = { 1, 2, 3, 4, 5, 6 };
		System.out.println("sum is :" + Arrays.toString(SUM.runningsum(input1)));
	}
}
