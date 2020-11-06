import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class PersonTest {

	@Test
	void testPerson() {
		Person person1 = new Person("Ted", 22);
		Person person2 = new Person("ted", 22);
		// assertEqauls uses == to compare primitives
		// to compare 2 ints ages
		assertEquals(person1.age, person2.age);
		// assertEquals uses equals method implemented in person class
		assertNotEquals(person1, person2);
		//
		Person person3 = new Person("Ted", 34);

		assertEquals(person1, person3);

	}

}
