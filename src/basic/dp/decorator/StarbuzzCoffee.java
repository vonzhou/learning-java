package basic.dp.decorator;

public class StarbuzzCoffee {
	public static void main(String[] args) {
		Beverage b = new Espresso();
		System.out.println(b.getDescription() + ", $" +b.cost());
		Beverage b2 = new DarkRoast();
		b2 = new Mocha(b2);
		b2 = new Mocha(b2);
		b2 = new Soy(b2);
		System.out.println(b2.getDescription() + ", $" +b2.cost());
	}

}
