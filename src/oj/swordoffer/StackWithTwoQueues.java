package oj.swordoffer;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithTwoQueues<T> {
	Queue<T> queue1;
	Queue<T> queue2;
	int size = 0;
	
	public StackWithTwoQueues(){
		queue1 = new LinkedList<T>();
		queue2 = new LinkedList<T>();
	}
	
	public void push(T e){
		queue1.add(e);
		size ++;
	}
	
	public T pop(){
		return findLastested(queue1,queue2);
	}

	// 把算法单独出来 不要总是操纵Class的成员变量
	private T findLastested(Queue<T> q1, Queue<T> q2) {
		if(size <=0)
			return null;
		int sum = q2.size();
		sum = size - sum;
		if(sum == 0){
			return findLastested(q2, q1);
		}else if(sum < 0){
			System.out.println("Error......");
			return null;
		}
		for(int i=0; i<sum-1;i++){
			q2.add(q1.remove());
		}
		T last = q1.remove();
		size --;
		return last;
	}
	
	public static void main(String[] args) {
		StackWithTwoQueues<Integer> stack = new StackWithTwoQueues<Integer>();
		for(int i=0; i< 5; i++)
			stack.push(i);
		System.out.println(stack.pop());
		stack.push(100);
		for(int i=0; i< 5; i++)
			System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
	

}
