package oj.swordoffer;

import java.util.Stack;

public class StackPushPopOrder {
	
	public static boolean isPopOrder(int[] input, int[] pop){
		if(input == null || pop == null || input.length != pop.length || input.length <= 0)
			return false;
		
		Stack<Integer> stack = new Stack<Integer>();
		int pushIndex = 0;
		int i = 0;  // next pop index 
		for(i=0; i<pop.length; i++){
			while(stack.isEmpty() || pop[i] != stack.peek()){
				if(pushIndex == input.length)
					break;
				stack.push(input[pushIndex]);
				pushIndex ++;
			}
			if(stack.peek() != pop[i])
				break;
			
			stack.pop();
		}
		
		if(stack.isEmpty() && i == pop.length)
			return true;
		return false;
	} 
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,};
		int[] b = {4,5,3,2,1,};
		int[] c = {1,2,3,4,5,};
		System.out.println(isPopOrder(a, b));
		System.out.println(isPopOrder(a, c));
	}

}
