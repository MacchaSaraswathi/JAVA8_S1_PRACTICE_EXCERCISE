package problemStatement_1;

import java.util.Scanner;

public class TestRectangle {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    rectangle[] rectangles = new rectangle[5];

    for (int i = 0; i < 5; i++) {
        System.out.print("Enter length for Rectangle " + (i + 1) + ": ");
        double length = scanner.nextDouble();

        System.out.print("Enter breadth for Rectangle " + (i + 1) + ": ");
        double breadth = scanner.nextDouble();

        rectangles[i] = new rectangle(length, breadth);
    }

    for (int i = 0; i < 5; i++) {
        System.out.println("\nRectangle " + (i + 1) + " Information:");
        rectangles[i].displayInformation();
    }

    scanner.close();
}
}


