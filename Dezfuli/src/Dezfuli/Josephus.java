/**
 * 
 */
package Dezfuli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * @author iman
 *
 */
public class Josephus {
	static List<Integer> josephus(final int n, final int k, final int s) {
		List<Integer> circle = new LinkedList<Integer>();
		List<Integer> sequence = new LinkedList<Integer>();
		Integer r;

		if (k < 1) {
			return circle;
		}

		for (int i = 0; i < n; ++i) {
			circle.add(i + 1);
		}

		for (int pos = s - 1 + k; circle.size() > 1; pos = pos + k) {
			if (pos > circle.size()) {
				pos = (pos - 1) % circle.size();
			} else {
				pos = pos - 1;
			}
			r = circle.remove(pos);
			sequence.add(r);
			System.out.printf("%S %s \n", circle, sequence);
		}
		sequence.add(circle.remove(0));
		return sequence;
	}

	static List<Integer> josephus(final int n, final int k) {
		return josephus(n, k, 1);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = 0, k = 0;

		try {
			System.out.println("\nenter number of positions (kids) in the circle(n):");
			n = Integer.parseInt(reader.readLine());
			System.out.println("enter number of skips (k):");
			k = Integer.parseInt(reader.readLine());
			List<Integer> result = josephus(n, k);
			System.out.printf("Sequence of n=%d, k=%d is(Winner is the last number):\n%s\n", n, k, result);
			System.out.printf("Winner is %d", result.get(result.size() - 1));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}