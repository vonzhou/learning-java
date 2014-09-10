package basic.dp.decorator;

//¶¹½¬µ÷ÁÏ
public class Soy extends CondimentDecorator{
	Beverage beverage;
	
	public Soy(Beverage b){
		this.beverage = b;
	}
	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}

	@Override
	public double cost() {
		return beverage.cost() + 0.15;
	}
}
