package object_oriented_programming;

public class Earth {
	public static void main(String arg[]) {
		
		Human human1 = new Human("Tom", 25, 76, "Blue");
		Human human2 = new Human("Joe", 28, 78, "Green");
//		Human human3 = new Human();
		
		human1.speak();
		System.out.println("");
		human2.speak();
//		human3.speak();
	}
}
