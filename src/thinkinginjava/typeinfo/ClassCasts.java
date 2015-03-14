package thinkinginjava.typeinfo;

class Building {
}

class House extends Building {
}

public class ClassCasts {
	public static void main(String[] args) {
		Building b = new House();// 向上转型不需要系那是的转型操作
		Class<House> houseType = House.class;
		House h = houseType.cast(b);
		h = (House) b; // ... or just do this.
	}
} 
