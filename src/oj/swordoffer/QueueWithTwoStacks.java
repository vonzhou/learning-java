package oj.swordoffer;

import java.util.Stack;

public class QueueWithTwoStacks<T> {
	Stack<T> stack1;
	Stack<T> stack2;
	
	public QueueWithTwoStacks() {
		stack1 = new Stack<T>();
		stack2 = new Stack<T>();
	}
	public void appendTail(T e){
		stack1.push(e);
	}
	
	public T delteHead(){
		T res;
		// 
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				T tmp = stack1.pop();
				stack2.push(tmp);
			}
		}
		
		
		if(stack2.isEmpty()){
			System.out.println("Queue is empty ....");
			return  null;
		}
		
		res = stack2.pop(); 
		return res;
	}
	
	public void showQueue(){
		
	}
	
	public static void main(String[] args) {
		QueueWithTwoStacks<String> qs = new QueueWithTwoStacks<String>();
		qs.appendTail("A");
		qs.appendTail("B");
		qs.appendTail("C");
		System.out.println(qs.delteHead());
		qs.appendTail("D");
		System.out.println(qs.delteHead());
		System.out.println(qs.delteHead());
		System.out.println(qs.delteHead());
		System.out.println(qs.delteHead());
		
		
	}

}
