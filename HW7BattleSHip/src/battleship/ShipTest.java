package battleship;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShipTest {
	// variables for cruiser so we don't need to redo everytime
	Ship cruiser = new Cruiser();
	int rowC = 0;
	int columnC = 3;
	boolean horizontalC = true;
	// variables for destroyer so we don't need to redo everytime
	Ship destroyer = new Destroyer();
	int rowD = 0;
	int columnD = 2;
	boolean horizontalD = true;
	// variables for submarine so we don't need to redo everytime
	Ship submarine = new Submarine();
	int rowS = 0;
	int columnS = 1;
	boolean horizontalS = true;

	Ocean ocean;
	Ship ship;

	@BeforeEach
	void setUp() throws Exception {
		ocean = new Ocean();
	}

	@Test
	void testGetLength() {
		ship = new Battleship();
		assertEquals(4, ship.getLength());

		// TODO
		// More tests ob battleship of length 4
		ship = new Battleship();
		assertNotEquals(8, ship.getLength());
		assertEquals((-16 / -4), ship.getLength());
		assertEquals((0.4 / 0.1), ship.getLength());

		// test cruiser of length 3
		ship = new Cruiser();
		assertEquals(3, ship.getLength());
		assertNotEquals((9.0 / 3), ship.getLength());
		assertNotEquals(15, ship.getLength());

		// test destroyer of length 2
		ship = new Destroyer();
		assertEquals(2, ship.getLength());
		assertNotEquals(-1, ship.getLength());
		assertNotEquals(1000000000, ship.getLength());

		// test submarin eof length 1
		ship = new Submarine();
		assertEquals(1, ship.getLength());
		assertEquals(00000001, ship.getLength());
		assertNotEquals(0, ship.getLength());
	}

	@Test
	void testGetBowRow() {
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);
		assertEquals(row, battleship.getBowRow());

		// TODO
		// More tests
		cruiser.placeShipAt(rowC, columnC, horizontalC, ocean);
		assertEquals(rowC, cruiser.getBowRow());
		assertEquals((4 * rowC), cruiser.getBowRow());
		assertEquals(0, cruiser.getBowRow());
		assertNotEquals(5, cruiser.getBowRow());

		destroyer.placeShipAt(rowD, columnD, horizontalD, ocean);
		assertEquals(rowD, destroyer.getBowRow());
		assertEquals((4 * rowD), destroyer.getBowRow());
		assertEquals((rowD * rowD), destroyer.getBowRow());
		assertNotEquals(-5, destroyer.getBowRow());

		submarine.placeShipAt(rowS, columnS, horizontalS, ocean);
		assertEquals(rowS, submarine.getBowRow());
		assertEquals((4 * rowS), submarine.getBowRow());
		assertEquals((rowS * rowS), submarine.getBowRow());
		assertNotEquals(-5, submarine.getBowRow());

	}

	@Test
	void testGetBowColumn() {
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);
		battleship.setBowColumn(column);
		assertEquals(column, battleship.getBowColumn());

		// TODO
		// More tests

		assertEquals(16 * column / 16, battleship.getBowColumn());
		assertNotEquals(-column, battleship.getBowColumn());

		cruiser.placeShipAt(rowC, columnC, horizontalC, ocean);
		cruiser.setBowColumn(columnC);
		assertEquals(columnC, cruiser.getBowColumn());
		assertEquals((3 * columnC / 3), cruiser.getBowColumn());
		assertNotEquals((3 * columnC), cruiser.getBowColumn());

		destroyer.placeShipAt(rowD, columnD, horizontalD, ocean);
		destroyer.setBowColumn(columnD);
		assertEquals(2 * columnD / 2, destroyer.getBowColumn());
		assertNotEquals(2 * columnD, destroyer.getBowColumn());

		submarine.placeShipAt(rowS, columnS, horizontalS, ocean);
		submarine.setBowColumn(columnS);
		assertEquals(9 * columnS / 9, submarine.getBowColumn());
		assertNotEquals(9 * columnS, submarine.getBowColumn());

	}

	@Test
	void testGetHit() {
		ship = new Battleship();
		boolean[] hits = new boolean[4];
		assertArrayEquals(hits, ship.getHit());
		assertFalse(ship.getHit()[0]);
		assertFalse(ship.getHit()[1]);

		// TODO
		// More tests
		int row = 0;
		int column = 8;
		boolean horizontal = true;
		ship.placeShipAt(row, column, horizontal, ocean);
		ship.shootAt(row, column);
		hits[0] = true;
		assertArrayEquals(hits, ship.getHit());
		assertTrue(ship.getHit()[0]);
		// test case 3: 1 shot, miss the hit
		ocean = new Ocean();
		ship = new Cruiser();
		ship.placeShipAt(row, column, horizontal, ocean);
		ship.shootAt(0, 0);
		hits = new boolean[4];
		assertArrayEquals(hits, ship.getHit());
	}

	@Test
	void testIsHorizontal​() {
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);
		assertTrue(battleship.isHorizontal());

		// TODO
		// More tests
		cruiser.placeShipAt(rowC, columnC, horizontalC, ocean);
		assertTrue(cruiser.isHorizontal());

		submarine.placeShipAt(rowS, columnS, horizontalS, ocean);
		assertTrue(submarine.isHorizontal());

		destroyer.placeShipAt(rowD, columnD, horizontalD, ocean);
		assertTrue(destroyer.isHorizontal());
	}

	@Test
	void testGetShipType() {
		ship = new Battleship();
		assertEquals("battleship", ship.getShipType());

		// TODO
		// More tests
		ship = new Destroyer();
		assertEquals("destroyer", ship.getShipType());

		ship = new Submarine();
		assertEquals("submarine", ship.getShipType());

		ship = new Cruiser();
		assertEquals("cruiser", ship.getShipType());

		ship = new Destroyer();
		assertNotEquals("", ship.getShipType());

	}

	@Test
	void testSetBowRow() {
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.setBowRow(row);
		assertEquals(row, battleship.getBowRow());

		// TODO
		// More tests
		assertNotEquals((row - 1), battleship.getBowRow());

		// cruiser
		cruiser.setBowRow(rowC);
		assertEquals(rowC, cruiser.getBowRow());
		assertEquals(2 * rowC, cruiser.getBowRow());
		assertNotEquals((3 - rowC), cruiser.getBowRow());

		// Destroyer
		destroyer.setBowRow(rowD);
		assertEquals(rowD, destroyer.getBowRow());
		assertEquals(200 * rowD, destroyer.getBowRow());
		assertEquals(rowD, destroyer.getBowRow());
		assertEquals((rowD / 8), destroyer.getBowRow());

		// submarine
		submarine.setBowRow(rowS);
		assertEquals(rowS, submarine.getBowRow());
		assertEquals(0002 * rowS, submarine.getBowRow());
		assertEquals((row - rowS), cruiser.getBowRow());

	}

	@Test
	void testSetBowColumn() {
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.setBowColumn(column);
		assertEquals(column, battleship.getBowColumn());

		// TODO
		// More tests
		submarine.setBowColumn(columnS);
		assertEquals(columnS, submarine.getBowColumn());

		cruiser.setBowColumn(columnC);
		assertEquals(columnC, cruiser.getBowColumn());

		destroyer.setBowColumn(columnD);
		assertEquals(columnD, destroyer.getBowColumn());
	}

	@Test
	void testSetHorizontal() {
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.setHorizontal(horizontal);
		assertTrue(battleship.isHorizontal());

		// TODO
		// More tests
		cruiser.setHorizontal(horizontalC);
		assertTrue(cruiser.isHorizontal());

		destroyer.setHorizontal(horizontalD);
		assertTrue(destroyer.isHorizontal());

		submarine.setHorizontal(horizontalS);
		assertTrue(submarine.isHorizontal());
	}

	@Test
	void testOkToPlaceShipAt() {

		// test when other ships are not in the ocean
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		boolean ok = battleship.okToPlaceShipAt(row, column, horizontal, ocean);
		assertTrue(ok, "OK to place ship here.");

		// TODO
		// More tests
		boolean okS = submarine.okToPlaceShipAt(rowS, columnS, horizontalS, ocean);
		assertTrue(okS, "OK to place ship here.");

		boolean okD = destroyer.okToPlaceShipAt(rowD, columnD, horizontalD, ocean);
		assertTrue(okD, "OK to place ship here.");

		boolean okC = cruiser.okToPlaceShipAt(rowC, columnC, horizontalC, ocean);
		assertTrue(okC, "OK to place ship here.");
	}

	@Test
	void testOkToPlaceShipAtAgainstOtherShipsOneBattleship() {

		// test when other ships are in the ocean

		// place first ship
		Battleship battleship1 = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		boolean ok1 = battleship1.okToPlaceShipAt(row, column, horizontal, ocean);
		assertTrue(ok1, "OK to place ship here.");
		battleship1.placeShipAt(row, column, horizontal, ocean);

		// test second ship
		Battleship battleship2 = new Battleship();
		row = 1;
		column = 4;
		horizontal = true;
		boolean ok2 = battleship2.okToPlaceShipAt(row, column, horizontal, ocean);
		assertFalse(ok2, "Not OK to place ship vertically adjacent below.");

		// TODO
		// More tests
		// place first ship
		boolean okS = submarine.okToPlaceShipAt(rowS, columnS, horizontalS, ocean);
		assertTrue(ok1, "OK to place ship here.");
		submarine.placeShipAt(rowS, columnS, horizontalS, ocean);

		// test second ship
		boolean okS2 = battleship2.okToPlaceShipAt(rowS, columnS, horizontalS, ocean);
		assertFalse(okS2, "Not OK to place ship vertically adjacent below.");

		// place first ship
		boolean okC = cruiser.okToPlaceShipAt(rowC, columnC, horizontalC, ocean);
		assertFalse(okC, "OK to place ship here.");
		cruiser.placeShipAt(rowC, columnC, horizontalC, ocean);

		// test second ship
		boolean okC2 = cruiser.okToPlaceShipAt(rowC, columnC, horizontalC, ocean);
		assertFalse(okC2, "Not OK to place ship vertically adjacent below.");

		// place first ship
		boolean okD = destroyer.okToPlaceShipAt(rowD, columnD, horizontalD, ocean);
		assertFalse(okD, "OK to place ship here.");
		destroyer.placeShipAt(rowD, columnD, horizontalD, ocean);

		// test second ship
		boolean okD2 = destroyer.okToPlaceShipAt(rowD, columnD, horizontalD, ocean);
		assertFalse(okD2, "Not OK to place ship vertically adjacent below.");

	}

	@Test
	void testPlaceShipAt() {

		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);
		assertEquals(row, battleship.getBowRow());
		assertEquals(column, battleship.getBowColumn());
		assertTrue(battleship.isHorizontal());

		assertEquals("empty", ocean.getShipArray()[0][0].getShipType());
		assertEquals(battleship, ocean.getShipArray()[0][1]);

		// TODO
		// More testS
		// submarine
		submarine.placeShipAt(rowS, columnS, horizontalS, ocean);
		assertEquals(rowS, submarine.getBowRow());
		assertEquals(columnS, submarine.getBowColumn());
		assertTrue(submarine.isHorizontal());

		assertEquals("empty", ocean.getShipArray()[0][0].getShipType());
		assertEquals(submarine, ocean.getShipArray()[0][1]);

		// cruiser
		cruiser.placeShipAt(rowC, columnC, horizontalC, ocean);
		assertEquals(rowC, cruiser.getBowRow());
		assertEquals(columnC, cruiser.getBowColumn());
		assertTrue(cruiser.isHorizontal());

		assertEquals("empty", ocean.getShipArray()[0][0].getShipType());
		assertEquals(cruiser, ocean.getShipArray()[0][1]);

		// destroyer
		destroyer.placeShipAt(rowD, columnD, horizontalD, ocean);
		assertEquals(rowD, destroyer.getBowRow());
		assertEquals(columnD, destroyer.getBowColumn());
		assertTrue(destroyer.isHorizontal());

		assertEquals("empty", ocean.getShipArray()[0][0].getShipType());
		assertEquals(destroyer, ocean.getShipArray()[0][1]);
	}

	@Test
	void testShootAt() {

		Ship battleship = new Battleship();
		int row = 0;
		int column = 9;
		boolean horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);

		assertFalse(battleship.shootAt(1, 9));
		boolean[] hitArray0 = { false, false, false, false };
		assertArrayEquals(hitArray0, battleship.getHit());

		// TODO
		// More tests
		// destroyer
		destroyer.placeShipAt(rowD, columnD, horizontalD, ocean);
		assertFalse(destroyer.shootAt(1, 9));
		boolean[] hitArray1 = { false, false, false, false };
		assertArrayEquals(hitArray1, destroyer.getHit());
		// cruiser
		cruiser.placeShipAt(rowC, columnC, horizontalC, ocean);
		assertFalse(cruiser.shootAt(1, 9));
		boolean[] hitArray2 = { false, false, false, false };
		assertArrayEquals(hitArray2, cruiser.getHit());
		// submarine
		submarine.placeShipAt(rowS, columnS, horizontalS, ocean);
		assertFalse(submarine.shootAt(1, 9));
		boolean[] hitArray3 = { false, false, false, false };
		assertArrayEquals(hitArray3, submarine.getHit());
	}

	@Test
	void testIsSunk() {

		Ship submarine = new Submarine();
		int row = 3;
		int column = 3;
		boolean horizontal = true;
		submarine.placeShipAt(row, column, horizontal, ocean);

		assertFalse(submarine.isSunk());
		assertFalse(submarine.shootAt(5, 2));
		assertFalse(submarine.isSunk());

		// TODO
		// More tests
		// battleship
		Ship battleship = new Battleship();
		int rowB = 3;
		int columnB = 3;
		boolean horizontalB = true;
		battleship.placeShipAt(rowB, columnB, horizontalB, ocean);
		assertFalse(battleship.isSunk());
		assertFalse(battleship.shootAt(5, 2));
		assertFalse(battleship.isSunk());

		// cruiser
		cruiser.placeShipAt(rowC, columnC, horizontalC, ocean);
		assertFalse(cruiser.isSunk());
		assertFalse(cruiser.shootAt(5, 2));
		assertFalse(cruiser.isSunk());

		// destroyer
		destroyer.placeShipAt(rowD, columnD, horizontalD, ocean);
		assertFalse(destroyer.isSunk());
		assertFalse(destroyer.shootAt(5, 2));
		assertFalse(destroyer.isSunk());

	}

	@Test
	void testToString() {

		Ship battleship = new Battleship();
		assertEquals("x", battleship.toString());

		int row = 9;
		int column = 1;
		boolean horizontal = false;
		battleship.placeShipAt(row, column, horizontal, ocean);
		battleship.shootAt(9, 1);
		assertEquals("x", battleship.toString());

		// TODO
		// More tests
		// submarine
		submarine.placeShipAt(rowS, columnS, horizontalS, ocean);
		submarine.shootAt(9, 1);
		assertEquals("x", submarine.toString());

		// cruiser
		cruiser.placeShipAt(rowC, columnC, horizontalC, ocean);
		cruiser.shootAt(9, 1);
		assertEquals("x", cruiser.toString());

		// destroyer
		destroyer.placeShipAt(rowD, columnD, horizontalD, ocean);
		destroyer.shootAt(9, 1);
		assertEquals("x", destroyer.toString());
	}

}
