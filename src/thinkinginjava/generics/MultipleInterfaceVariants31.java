package thinkinginjava.generics;

// TIJ4 Chapter Generics, Exercise 31, page 697
// Remove all generics from MultipleInterfaceVariants.java and modify
// the code so that the example compiles.

interface Payable2 { float getPay(); }

class Employee2 implements Payable2 {
	private float weeklyPay;
	public float getPay() {
		return weeklyPay;
	}		
} 

class Hourly2 extends Employee2 implements Payable2{
	public String name;
	protected float hourlyPay;
	public int hoursWorked;
	Hourly2(String s, float pay, int hours) {
		name = s;
		hourlyPay = pay;
		hoursWorked = hours;
	}
	public float getPay() {
		System.out.println("Pay " + name + 
			" $" + hourlyPay * hoursWorked);
		return hourlyPay * hoursWorked;	
	}
}

public class MultipleInterfaceVariants31 {
	public static void main(String[] args) {
		Hourly2 h = new Hourly2("Joe", 50.00f, 40);
		h.getPay();
		
		System.out.println("=============");
		Payable2 p = new Hourly2("Joe", 50.00f, 40);
		p.getPay();
	}
}



