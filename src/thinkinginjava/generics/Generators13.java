package thinkinginjava.generics;

// TIJ4 Chapter Generics, Exercise 13, page 637
/* Overload the fill() method so that the arguments and return types are
* the specific subtypes of Collection: List, Queue and Set. This way, you
* don't lose the type of container. Can you overload to distinguish between
* List and LinkedList?
*/
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import thinkinginjava.generics.coffee.Coffee;
import thinkinginjava.generics.coffee.CoffeeGenerator;
import thinkinginjava.util.Generator;

public class Generators13 {
	public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
		for(int i = 0; i < n; i++) coll.add(gen.next());
		return coll;
	}
	public static <T> List<T> fill(List<T> l, Generator<T> gen, int n) {
		for(int i = 0; i < n; i++) l.add(gen.next());
		return l;
	}
	public static <T> Queue<T> fill(Queue<T> q, Generator<T> gen, int n) {
		for(int i = 0; i < n; i++) q.add(gen.next());
		return q;
	}
	public static <T> Set<T> fill(Set<T> s, Generator<T> gen, int n) {
		for(int i = 0; i < n; i++) s.add(gen.next());
		return s;
	}
	// return type LinkedList:
	public static <T> LinkedList<T> fill(LinkedList<T> ll, Generator<T> gen, int n) {
		for(int i = 0; i < n; i++) ll.add(gen.next());
		return ll;
	}
	
	
	public static void main(String[] args) {
		Collection<Coffee> coffee = fill(new ArrayList<Coffee>(), new CoffeeGenerator(), 4);
		for(Coffee c : coffee) System.out.println(c);
		Collection<Integer> fnumbers = fill(new ArrayList<Integer>(), new Fibonacci(), 12);
		for(int i : fnumbers) System.out.print(i + ", ");
		println();
		
		List<Coffee> coffeeList = fill(new ArrayList<Coffee>(), new CoffeeGenerator(), 5);
		println("List type: " + coffeeList.getClass());
		println("coffeeList:" + coffeeList);	
		
		Queue<Coffee> coffeeQueue = fill(new ArrayDeque<Coffee>(), new CoffeeGenerator(), 5);
		println("Queue type: " + coffeeQueue.getClass());
		println("coffeeQueue: " + coffeeQueue); 
		
		Set<Coffee> coffeeSet = fill(new HashSet<Coffee>(), new CoffeeGenerator(), 5);
		println("Set type: " + coffeeSet.getClass());
		println("coffeeSet: " + coffeeSet);
		
		LinkedList<Coffee> coffeeLinkedList = fill(new LinkedList<Coffee>(), new CoffeeGenerator(), 5);
		println("LinkedList type: " + coffeeLinkedList.getClass());
		println("coffeeLinkedList: " + coffeeLinkedList);
	}
	private static void println(String string) {
		System.out.println(string);
	}
	private static void println() {
		System.out.println();
	}
}
