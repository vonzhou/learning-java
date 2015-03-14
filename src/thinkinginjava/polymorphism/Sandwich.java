// Order of constructor calls.
package thinkinginjava.polymorphism;

import static thinkinginjava.util.Print.*;

// 基类构造器（递归）  -- 成员的初始化  -- 导出类的构造器

class Meal {
	Meal() {
		print("Meal()");
	}
}

class Bread {
	Bread() {
		print("Bread()");
	}
}

class Cheese {
	Cheese() {
		print("Cheese()");
	}
}

class Lettuce {
	Lettuce() {
		print("Lettuce()");
	}
}

class Lunch extends Meal {
	Lunch() {
		print("Lunch()");
	}
}

class PortableLunch extends Lunch {
	PortableLunch() {
		print("PortableLunch()");
	}
}

public class Sandwich extends PortableLunch {
	private Bread b = new Bread();
	private Cheese c = new Cheese();
	private Lettuce l = new Lettuce();

	public Sandwich() {
		print("Sandwich()");
	}

	public static void main(String[] args) {
		new Sandwich();
	}
} 
