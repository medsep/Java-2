package train1.com.fx1;

public class Iteration1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] myintArray = { 100, 200, 5, 8, 9, 6, 9 };
		int index = 0;
		while (index < myintArray.length) {
			System.out.println(myintArray[index]);
			index++;
		}

		for (int idx = 0; idx < myintArray.length; idx++) {
			System.out.println(myintArray[idx]);
		}

		for (int element : myintArray) {
			System.out.println(element);
		}

	}

}
