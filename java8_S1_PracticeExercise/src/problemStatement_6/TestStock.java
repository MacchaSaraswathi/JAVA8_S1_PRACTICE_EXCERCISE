package problemStatement_6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class TestStock {
	
	public static void main(String[] args) {
		List<Stock> stock = new ArrayList<>();
		Scanner s = new Scanner(System.in);
		for(int i=1;i<=5;i++)
		{
			System.out.println("Enter Symbol");
			String symbol=s.next();
			System.out.println("Enter price");
			double price=s.nextDouble();
			System.out.println("Enter quantity");
			double quantity=s.nextDouble();
			Stock s1 = new Stock(symbol,price,quantity);
			stock.add(s1);
		}
		stock.forEach(System.out::println);
		System.out.println("-----Symbol equals to AMZ-----");
		Predicate<Stock> bySymbol=stock1->stock1.getSymbol().equals("AMZ");
		List<Stock> lstock=StockFilter.filter(stock, bySymbol);
		lstock.forEach(System.out::println);
		System.out.println("-----Price above 300-----");
		Predicate<Stock> byCost = stock1->stock1.getPrice()>300;
		List<Stock> byCostl=StockFilter.filter(stock, byCost);
		byCostl.forEach(System.out::println);
		
	}

}


