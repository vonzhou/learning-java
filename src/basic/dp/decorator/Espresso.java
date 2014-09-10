package basic.dp.decorator;

//浓缩咖啡
public class Espresso extends Beverage{
	//为了重新设置饮料的描述，这里在构造方法中重置继承自基类的变量
	public Espresso(){
		description = "Espresso";
	}
	
	public double cost() {
		return 1.99;
	}
}
