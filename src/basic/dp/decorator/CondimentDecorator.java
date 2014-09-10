package basic.dp.decorator;

public abstract class CondimentDecorator extends Beverage{
	//要求所有的调料都要重新实现这个方法；
	public abstract String getDescription();
}
