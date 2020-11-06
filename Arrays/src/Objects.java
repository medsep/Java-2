import java.awt.Point;
import java.awt.Rectangle;

public class Objects {

	public static void printPoint(Point p) {
		System.out.println("(" + p.x + ", " + p.y + ")");
	}

	public static double distance(Point p1, Point p2) {
		int dx = p2.x - p1.x;
		int dy = p2.y - p1.y;
		return Math.sqrt(dx * dx + dy * dy);
	}

	public static Point findCenter(Rectangle box) {
		int x = box.x + box.width / 2;
		int y = box.y + box.height / 2;
		return new Point(x, y);
	}

	public static void main(String[] args) {

		Point blank, plank;
		blank = new Point(3, 4);
		plank = new Point(8, 13);
		System.out.println(blank);
		printPoint(blank);
		System.out.println(distance(blank, plank));

		Rectangle box = new Rectangle(0, 0, 100, 200);
		box.x = box.x + 50;
		box.y = box.y + 100;

		Rectangle box1 = new Rectangle(0, 0, 100, 200);
		moveRect(box1, 50, 100);
		System.out.println(box1);

	}

	public static void moveRect(Rectangle box, int dx, int dy) {
		box.x = box.x + dx;
		box.y = box.y + dy;
	}

}
