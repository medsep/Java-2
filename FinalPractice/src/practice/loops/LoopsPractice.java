package practice.loops;

public class LoopsPractice {

	public static void main(String[] args) {
		
//		int count = 0;
//		
//		while (count <= 100) {
//			System.out.println("Peter: " + count);
////			System.out.println(count);
//			count++;
//			
//			if (count == 10) {
//				break;
//			}
//			//break;
//		}
		
		
		String str = "We have a large inventory of things in our warehouse falling in the category:appearal and the slightly more in demand category:makeup along with the category:furniture and ...";
		
		printCategories(str);
		//=====================
		
//		String name = "sakdadakfjnkel";
//		for (int i = name.length() - 1; i >= 0; i--) {
//			System.out.println("char: " + name.charAt(i));
//		}
		
//		for (int i = 0; i<=100; i+=2) {
////			if (i%2 == 0) {
////				System.out.println(i);
////			}
//			System.out.println(i);
//		}
		

		for (int idx = 0; idx < 100; idx++) {
			
			for(int j = 0; j < 10 ; j++) {
				System.out.println("the value of idx was: " + idx + " ----- " + j);
			}
		}
		
	}
	
	public static void printCategories(String str) {
		String local = str;
		
		while (local.indexOf(":") != -1) {
			local = local.substring(local.indexOf(":") + 1);
			System.out.println(local.substring(0, local.indexOf(" ")));
		}
		
	}

}
