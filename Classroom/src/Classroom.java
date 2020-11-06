import java.util.ArrayList;

/*
 * Represents a classroom with students
 * Each class has list of students
 * and an array that represents seats in classroom
 */
public class Classroom {

	// instance variables
	/**
	 * Building name
	 */
	String buildingName;

	/**
	 * Name of classroom
	 * 
	 * @param args
	 */
	String roomName;

	/*
	 * list of students
	 */

	ArrayList<Student> students;

	/*
	 * seats of class room. 2d array
	 */
	Seat[][] seats;

	// constructor
	public Classroom(String buildingName, String roomName, int rows, int columns) {

		// set building name
		this.buildingName = buildingName;
		// set room name
		this.roomName = roomName;

		// initlalize seats array
		this.seats = new Seat[rows][columns];

		// populate arrays by interation
		for (int i = 0; i < rows; i++) {

			// iterate over columns
			for (int j = 0; j < columns; j++) {
				// give each location own instance of seat class
				// given i and j is the row and column in the array
				seats[i][j] = new Seat(i, j);
			}
		}
		// initialize list of students
		this.students = new ArrayList<Student>();
	}

	/*
	 * Add a student to the list of students.
	 */
	public void addAStudent(Student student) {
		this.students = new ArrayList<Student>();
	}

	/*
	 * Finds an available seat and assigns to a given student.
	 */
	public void assignStudentToSeat(Student student) {
		int rows = this.seats.length; // gets the number of rows off seats
		int columns = this.seats[0].length; // gets the number of columns of seats
		// iterate over rows and columns and visit each seat
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				// get seat in location and see if available by checking
				// if there is a student in the seat
				if (this.seats[i][j].studentInSeat == null) {// if null no student has been assigned
					// assign given student
					this.seats[i][j].putStudentInSeat(student);
					// exits loop and method at once
					return;
				}
			}
		}
	}

	/**
	 * print all students in classroom
	 */
	public void printAllStudents() {
		System.out.println("Students in class: ");

		for (Student student : this.students) {
			System.out.println(student); // this will call the 2student method in student class
		}
	}

	public String toString() {
		String s = "\n";

		int rows = this.seats.length; // gets the number of rows off seats
		int columns = this.seats[0].length; // gets the number of columns of seats
		// iterate over rows and columns and visit each seat
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				s += this.seats[i][j] + "\t"; // calls the toString method in seat class
			}
			s += "\n"; // adds newline at end of each row
		}
		return s;
	}

	public static void main(String[] args) {
		// create classroom
		Classroom huntsman = new Classroom("HH", "105", 10, 5);
		// Create students
		Student fin = new Student("fin", "fingnew");
		Student bob = new Student("bob", "roberts");
		// addd students to classroom
		huntsman.addAStudent(fin);
		huntsman.addAStudent(bob);

		// assign students to seats
		huntsman.assignStudentToSeat(fin);
		huntsman.assignStudentToSeat(bob);

		// print
		huntsman.printAllStudents();

		// print
		System.out.println(huntsman); // this will also call the the toString method in classroom
	}

}
