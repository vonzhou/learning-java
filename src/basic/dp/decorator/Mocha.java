package basic.dp.decorator;

//摩卡调料
public class Mocha extends CondimentDecorator{
	Beverage beverage;
	
	//想办法让被装饰者（饮料）记录到实例变量中
	public Mocha(Beverage b){
		this.beverage = b;
	}
	//装饰者还要能描述其装饰的对象的特点
	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}

	@Override
	public double cost() {
		return beverage.cost() + 0.20;
	}
}
