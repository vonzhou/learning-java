package oj.leetcode.stack;


import algrithm.sedgewick.stack.Stack;

/*
 * Design a stack that supports push, pop, top, and retrieving the 
 * minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * 1. 如果每次push的时候维护有序数列 这是否损坏了栈的性质？只保证getMin是常数时间复杂度？
 * 2.巧妙的方法是 利用 两个栈，用其中一个栈保存这段时间的最小值
 * 栈空的时候怎么处理？不能抛出异常，cannot find symbol: class NoSuchElementException
 * 所以不用处理，让底层的Stack来处理异常。
 * 
 * 相关题目：谷歌面试题 - 
 * Design a queue that supports push_rear, pop_front, and get_min in O(1). 
 * Would that be elegantly possible too?
 * 
 * 相关题目 -  Sliding Window Maximum
 */
public class MinStack {
	//这里用的是Stack当然可以用其他数据结构
	Stack<Integer> storage = new Stack<Integer>();
	Stack<Integer> currentMinStack = new Stack<Integer>();
	
	public void push(int x) {
		if(storage.isEmpty() || x <= currentMinStack.peek()){
			//storage.push(x);
			currentMinStack.push(x);
		}
		//注意总会执行 这里 就因为上面那个失误  导致错误 Runtime Error
		storage.push(x);
	}

	public void pop() {
		if(storage.isEmpty())
			return;
		int x = storage.pop();
		if(x == currentMinStack.peek())
			currentMinStack.pop();
	}

	public int top() {
		return storage.peek();
	}

	public int getMin() {
		return currentMinStack.peek();
	}
	
	public static void main(String[] args) {
		
		MinStack ms = new MinStack();
		ms.push(2147483646);
		ms.push(2147483646);
		ms.push(2147483647);
		System.out.println(ms.top());
		System.out.println(ms.top());
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.getMin());
		ms.pop();
		ms.push(2147483647);
		System.out.println(ms.top());
		System.out.println(ms.getMin());
		ms.push(-2147483648);
		System.out.println(ms.top());
		System.out.println(ms.getMin());
		System.out.println(ms.top());
		System.out.println(ms.getMin());
		/*
		System.out.println(ms.getMin());
		System.out.println(ms.getMin());
		ms.pop();
		ms.pop();
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.getMin());
		ms.pop();
		ms.pop();
		System.out.println(Integer.MAX_VALUE);
		*/
	}
}
/*
 答案揭晓：
Consider space-time tradeoff. 
How would you keep track of the minimums using extra space?
Make sure to consider duplicate elements.

O(n) runtime, O(n) space – Extra stack:

Use an extra stack to keep track of the current minimum value. 
During the push operation we choose the new element or the current minimum, 
whichever that is smaller to push onto the min stack.

O(n) runtime, O(n) space – Minor space optimization:

If a new element is larger than the current minimum, 
we do not need to push it on to the min stack. When we perform 
the pop operation, check if the popped element is the same as the 
current minimum. If it is, pop it off the min stack too.
 * 
 * */
