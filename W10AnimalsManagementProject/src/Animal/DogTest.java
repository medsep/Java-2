package Animal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DogTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testEqualsObject() {
		// this assumes we implement equals method

		Dog dog1 = new Dog(4, "Pug");
		dog1.setName("Tommy");

		Dog dog2 = new Dog(8, "Pug");
		dog2.setName("Tommy");

		// dogs should be equal, cosisdered equla in name and breeds are equals
		assertEquals(dog1, dog2);

	}

}
