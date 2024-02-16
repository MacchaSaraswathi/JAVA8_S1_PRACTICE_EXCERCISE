package problemStatement_7;

import java.util.function.Function;

public class BurgerShop implements Burger {
	
	private  Burger burger;
	private  Function<Burger,String> decorator;
	

	public BurgerShop(Burger burger, Function<Burger, String> decorator) {
		super();
		this.burger = burger;
		this.decorator = decorator;
	}


	@Override
	public String makeBurger() {
		// TODO Auto-generated method stub
		return decorator.apply(burger);
	}

}


