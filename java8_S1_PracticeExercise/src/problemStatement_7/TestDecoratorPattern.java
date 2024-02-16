package problemStatement_7;

public class TestDecoratorPattern {
public static void main(String[] args) {
	Burger b = new BaseBurger();
	Burger veg = new BurgerShop(b,burger->burger.makeBurger()+"  burger\nAdding veggies to the burger");
	Burger cheese = new BurgerShop(b,burger->burger.makeBurger()+" Cheee\nAdding Cheese to the burger");
	System.out.println(veg.makeBurger());
	System.out.println(cheese.makeBurger());
	
}
}


