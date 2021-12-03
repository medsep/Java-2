package CollectionsExamples;

/**
 * autoboxing: complier wraps dattypes to object to stroe in array
 * 
 * @author mehdi
 *
 */
public class AutoBOxing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int var = 10;
		Integer obj = new Integer(var); // wrapping -->autoboxing
		System.out.println(obj);

		int i = obj; // unwrapping-->unboxing

	}

}
