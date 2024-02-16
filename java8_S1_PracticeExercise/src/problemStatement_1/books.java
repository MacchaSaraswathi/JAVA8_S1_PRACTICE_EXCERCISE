package problemStatement_1;

import java.util.Scanner;

class Book {
	private String title;
	private double price;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}

public class books {
	public static void main(String[] args) {
		Book[] books = createBooks(2);
		showBooks(books);
	}

	public static Book[] createBooks(int n) {
		Book[] books = new Book[n];
		for (int i = 0; i < n; i++) {
			Book book = new Book();
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter book title: ");
			String title = scanner.nextLine();
			System.out.print("Enter book price: ");
			double price = scanner.nextDouble();
			book.setTitle(title);
			book.setPrice(price);
			books[i] = book;
		}
		return books;
	}

	public static void showBooks(Book[] books) {
		for (Book book : books) {
			System.out.println(book.getTitle());
			System.out.printf("Rs %.2f\n\n", book.getPrice());
		}
	}

}
