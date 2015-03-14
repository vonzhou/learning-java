// Dynamically changing the behavior of an object
// via composition (the "State" design pattern).
package thinkinginjava.polymorphism;

import static thinkinginjava.util.Print.*;

class Actor {
	public void act() {
	}
}

class HappyActor extends Actor {
	public void act() {
		print("HappyActor");
	}
}

class SadActor extends Actor {
	public void act() {
		print("SadActor");
	}
}

class Stage {
	private Actor actor = new HappyActor();

	public void change() {
		actor = new SadActor();
	}

	public void performPlay() {
		actor.act();
	}
}

public class Transmogrify {
	public static void main(String[] args) {
		Stage stage = new Stage();
		stage.performPlay();
		stage.change();
		stage.performPlay();
	}
} /*
 * Output: HappyActor SadActor
 */// :~
