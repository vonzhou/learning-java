package oj.swordoffer;

import java.util.Stack;

public class StackWithMin<T> {
	Stack<T> data;
	Stack<T> currentMin ;
	public StackWithMin(){
		data = new Stack<T>();
		currentMin = new Stack<T>();
	}
	
	public void push(T e){
		data.push(e);
		
		if(currentMin.isEmpty() || less(e, currentMin.peek())){
			currentMin.push(e);
		}
		else currentMin.push(currentMin.peek());
	}

	// assume is inttegers in stack .....
	private boolean less(T e, T peek) {
		return (Integer)e < (Integer)peek;
	}
	public T pop(){
		if(data.isEmpty() || currentMin.isEmpty())
			return null;
		currentMin.pop();
		return data.pop();
	}
	
	public T min(){
		if(data.isEmpty() || currentMin.isEmpty())
			return null;
		return currentMin.peek();
	}
	
	public static void main(String[] args) {
		StackWithMin<Integer> sm = new StackWithMin<Integer>();
		for(int i=0; i<5; i++)
			sm.push(i);
		/*
		for(int i=0; i<5; i++)
			System.out.println(sm.pop());
		*/
		System.out.println(sm.min());
		System.out.println(sm.pop());
		System.out.println(sm.min());
		sm.push(-10);
		System.out.println(sm.min());
		
	}

}
