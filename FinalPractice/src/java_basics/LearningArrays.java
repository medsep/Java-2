package java_basics;

public class LearningArrays {

	public static void main(String[] args) {

		double[] values = new double[100];
		values[0] = 1000;
		values[1] = 1.11;
		values[99] = 93432;
		
		System.out.println(values[99]);
		
		String[] words = new String[] {"my", "name", "is"};
		System.out.println(words[words.length-1]);
		
		words = new String[10];
		System.out.println(words[0]);
		
		
		}

}
