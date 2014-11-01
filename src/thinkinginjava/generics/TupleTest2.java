package thinkinginjava.generics;

import thinkinginjava.util.FiveTuple;
import thinkinginjava.util.FourTuple;
import thinkinginjava.util.ThreeTuple;
 import  static thinkinginjava.util.Tuple.*;
import thinkinginjava.util.TwoTuple;

public class TupleTest2 {
	static TwoTuple<String, Integer> f() {
		return tuple("hi", 47);
	}

	static TwoTuple f2() {
		return tuple("hi", 47);
	}

	static ThreeTuple<Amphibian, String, Integer> g() {
		return tuple(new Amphibian(), "hi", 47);
	}

	static FourTuple<Vehicle, Amphibian, String, Integer> h() {
		return tuple(new Vehicle(), new Amphibian(), "hi", 47);
	}

	static FiveTuple<Vehicle, Amphibian, String, Integer, Double> k() {
		return tuple(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
	}

	public static void main(String[] args) {
		TwoTuple<String, Integer> ttsi = f();
		System.out.println(ttsi);
		System.out.println(f2());
		TwoTuple<String, Integer> test = f2();
		System.out.println(g());
		System.out.println(h());
		System.out.println(k());
	}
} 
