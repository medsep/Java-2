import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CounterTest {

	Counter counter; // declare counter for testing

	@BeforeEach
	void setUp() throws Exception {
		this.counter = new Counter();
	}

	@Test
	void testIncrement() {
		assertTrue(this.counter.increment() == 1);
		// return 2
		assertTrue(this.counter.increment() == 2);
		//
		this.counter.increment();
		// calling increment 3rd time should not return 2
		assertFalse(this.counter.getCount() == 2, "Should not return 2 after third time.");
		// expects 3 when calling getCount
		assertEquals(3, this.counter.getCount());
		// calling increment should not return 3
		assertNotEquals(3, this.counter.increment());
	}

	@Test
	void testDecrement() {
		// should return-1
		assertEquals(-1, this.counter.decrement());
		// should return-2
		assertTrue(this.counter.decrement() == -2);
		//
		this.counter.decrement();
		// should not be -2
		assertFalse(this.counter.getCount() == -2, "Should nor return -2 after calling decrement again.");
		//
		assertTrue(this.counter.getCount() == -3);
	}

}
