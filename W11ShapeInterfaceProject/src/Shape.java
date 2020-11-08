/**
 * Interface for various types of shapes
 * 
 * @author meh
 *
 */
public interface Shape {

	/**
	 * area of shape
	 * 
	 * @return
	 */
	public double area();

	/**
	 * perimeter of shape
	 * 
	 * @return
	 */
	public double perimeter();

	/**
	 * draws shape
	 */
	public void draw();

}
