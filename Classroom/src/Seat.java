/**
 * represents a seat in class room, with row and column for each associated with
 * it and it might or not have a student assigned to it.
 * 
 * @author meh
 *
 */
public class Seat {

	// instance vars
	/**
	 * seat row
	 */
	int row;
	/*
	 * seat column
	 */
	int column;
	/*
	 * student assigned
	 */
	Student studentInSeat;

	// constructor
	/*
	 * Creates a seat for class at the given row and column. row for seat
	 */
	public Seat(int row, int column) {
		this.row = row;
		this.column = column;
	}

	// method
	/*
	 * Assigns the given student to this seat
	 */

	public void putStudentInSeat(Student student) {
		this.studentInSeat = student;

	}

	/*
	 * return row and column for this seat
	 */
	@Override
	public String toString() {
		return this.row + ", " + this.column + ": " + this.studentInSeat;
	}

}
