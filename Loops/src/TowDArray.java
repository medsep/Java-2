
public class TowDArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] Array = new int[3][5];
		Array[0][0] = 1;
		Array[0][1] = 2;
		Array[0][2] = 3;
		Array[1][0] = 4;
		Array[1][1] = 5;
		Array[1][2] = 6;

		// System.out.println(Array[1][1]);
		// System.out.println(Array.length);
		// System.out.println(Array[0].length);

		for (int i = 0; i < Array.length; i++) {
			for (int j = 0; j < Array[i].length; j++) {
				System.out.print(Array[i][j] + " ");
			}
			System.out.println();
		}
	}

}
