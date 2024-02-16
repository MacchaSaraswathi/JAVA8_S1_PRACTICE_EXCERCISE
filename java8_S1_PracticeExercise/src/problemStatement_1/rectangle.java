package problemStatement_1;

public class rectangle {
	 private double length;
	 private double breadth;

	 // Constructors
	 public rectangle() {
	     this.length = 0;
	     this.breadth = 0;
	 }

	 public rectangle(double length, double breadth) {
	     this.length = length;
	     this.breadth = breadth;
	 }

	 // Accessor methods
	 public double getLength() {
	     return length;
	 }

	 public double getBreadth() {
	     return breadth;
	 }

	 // Mutator methods
	 public void setLength(double length) {
	     this.length = length;
	 }

	 public void setBreadth(double breadth) {
	     this.breadth = breadth;
	 }

	 // Pure functions
	 public double calculateArea() {
	     return length * breadth;
	 }

	 public void displayInformation() {
	     System.out.println("Length: " + length + ", Breadth: " + breadth + ", Area: " + calculateArea());
	 }
	}


