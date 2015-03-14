package thinkinginjava.reusing;

// Inheritance & upcasting.

class Instrument {
	public void play() {
	}

	static void tune(Instrument i) {
		// ...
		System.out.println("Tunning... " + i.getClass().getSimpleName());
		i.play();
	}
}

// Wind objects are instruments
// because they have the same interface:
public class Wind extends Instrument {
	
	public static void main(String[] args) {
		Wind flute = new Wind();
		Instrument.tune(flute); // Upcasting
		
		Instrument wind2 = new Wind();
		Instrument.tune(wind2);
	}
} // /:~
