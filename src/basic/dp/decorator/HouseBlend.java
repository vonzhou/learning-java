package basic.dp.decorator;

//星巴克独家调料咖啡
public class HouseBlend extends Beverage{
	public HouseBlend(){
		description = "House Blend Coffee";
	}
	
	public double cost() {
		return 1.89;
	}
}
