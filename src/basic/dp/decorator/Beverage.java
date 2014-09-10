package basic.dp.decorator;

//装饰者模式一般使用抽象类
public abstract class Beverage {
	String description = "unknown beverage";
	public String getDescription(){
		return description;
	}
	
	public abstract double cost();
}
