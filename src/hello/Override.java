package hello;


class Car {
	public void start() {
		System.out.println("This is a Generic start to any Car");
	}
}

class Ferrari extends Car {
	public void start() {
		System.out.println("Lets start the Ferrari and go out for a cool Party.");
	}
}

public class Override {
	public static void main(String[] args) {
		Car a = new Car();
		Car b = new Ferrari(); // Car ref, but a Ferrari object
		a.start(); // Runs the Car version of start()
		b.start(); // Runs the Ferrari version of start()
	}
}