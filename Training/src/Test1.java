
public class Test1 {

	// Function to find that number
	// is divisible by 9 or not
	static boolean check(String str) {
		// Compute sum of digits
		int n = str.length();
		int digitSum = 0;
		for (int i = 0; i < n; i++)
			digitSum += (str.charAt(i) - '0');

		// Check if sum of digits is divisible by 9.
		return (digitSum % 9 == 0);
	}

	// main function
	public static void main(String[] args) {
		String str = "9";
		if (check(str))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
