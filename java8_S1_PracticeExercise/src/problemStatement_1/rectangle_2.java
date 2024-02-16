package problemStatement_1;

public class rectangle_2 {

    private double length;
    private double width;

    public rectangle_2() {
        this.length = 1.0;
        this.width = 1.0;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if (isValidDimension(length)) {
            this.length = length;
        } else {
            System.out.println("Length must be a floating-point number larger than 0.0 and less than 20.0.");
        }
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (isValidDimension(width)) {
            this.width = width;
        } else {
            System.out.println("Width must be a floating-point number larger than 0.0 and less than 20.0.");
        }
    }

    private boolean isValidDimension(double dimension) {
        return dimension > 0.0 && dimension < 20.0;
    }

    public double perimeter() {
        return 2 * (length + width);
    }

    public double area() {
        return length * width;
    }

    public static void main(String[] args) {
        rectangle_2 rectangle = new rectangle_2();
        System.out.println("Default Length: " + rectangle.getLength());
        System.out.println("Default Width: " + rectangle.getWidth());

        rectangle.setLength(7.0);
        rectangle.setWidth(3.0);

        System.out.println("Modified Length: " + rectangle.getLength());
        System.out.println("Modified Width: " + rectangle.getWidth());

        System.out.println("Perimeter: " + rectangle.perimeter());
        System.out.println("Area: " + rectangle.area());
    }
}


