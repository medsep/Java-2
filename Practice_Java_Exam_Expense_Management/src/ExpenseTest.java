
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ExpenseTest {

	@Test
	void testExpense() {

		Expense expense = new Expense(12, 2.34);

		// confirm month number and amount
		assertEquals(12, expense.getMonth());
		assertEquals(2.34, expense.getAmount());

		// TODO Write more test cases
		assertNotEquals(55, 3.8);

		Expense expense1 = new Expense(5, 12.34);
		assertEquals(5, expense1.getMonth());
		assertEquals(12.34, expense1.getAmount());

		Expense expense2 = new Expense(5, 12.34);
		assertEquals(5, expense2.getMonth());
		assertNotEquals(8, expense2.getMonth());
		assertEquals(12.34, expense2.getAmount());

	}

	@Test
	void testEquals() {

		Expense expense1 = new Expense(12, 2.348);
		Expense expense2 = new Expense(11, 2.348);

		assertEquals(expense1, expense2);

		// TODO Write more test cases

		Expense expense3 = new Expense(6, 11.348);
		Expense expense4 = new Expense(5, 21.348);
		Expense expense5 = new Expense(11, 2.348);
		assertNotEquals(expense3, expense1);
		assertNotEquals(expense4, expense1);
		assertNotSame(expense3, expense4);
		assertSame(expense5, expense5);
	}

}
