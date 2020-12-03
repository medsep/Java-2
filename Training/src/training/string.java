package training;

public class string {

	public static void main(String args[]) {
		char[] helloArray = { 'h', 'e', 'l', 'l', 'o' };
		char[] worldArray = { 'w', 'o', 'r', 'l', 'd', '.' };
		String helloString = new String(helloArray);
		String worldString = new String(worldArray);
		System.out.println(helloString + " " + worldString);
	}

}
