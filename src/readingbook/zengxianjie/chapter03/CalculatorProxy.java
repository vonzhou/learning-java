package readingbook.zengxianjie.chapter03;

public class CalculatorProxy {
	private CalculatorImpl calculator;
	public CalculatorProxy(CalculatorImpl c){
		this.calculator = c;
	}
	public int add(int a, int b){
		// TODO something before
		int res = calculator.add(a, b);
		//TODO something after
		return res;
	}
}
