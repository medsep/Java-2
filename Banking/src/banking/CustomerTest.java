package banking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {

	Customer customer;

	@BeforeEach
	void setUp() throws Exception {
		this.customer = new Customer("Mehdi");
	}

	@Test
	void testSetAddress() {
		// confirms imitial address value is null
		assertNull(this.customer.getAddress());
		// set address for the customer
		this.customer.setAddress("Melbourne, VIC");
		// checks for correct address
		assertEquals("Melbourne, VIC", this.customer.getAddress());
		// reset address for customer
		this.customer.setAddress("Cranston, RI");
		// checks for address reset
		assertEquals("Cranston, RI", this.customer.getAddress());

	}

}
