package oj.leetcode;


import java.util.Stack;

/*
 * Design a stack that supports push, pop, top, and retrieving the 
 * minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * 1. ���ÿ��push��ʱ��ά���������� ���Ƿ�����ջ�����ʣ�ֻ��֤getMin�ǳ���ʱ�临�Ӷȣ�
 * 2.����ķ����� ���� ����ջ��������һ��ջ�������ʱ�����Сֵ
 * ջ�յ�ʱ����ô���������׳��쳣��cannot find symbol: class NoSuchElementException
 * ���Բ��ô����õײ��Stack�������쳣��
 * 
 * �����Ŀ���ȸ������� - 
 * Design a queue that supports push_rear, pop_front, and get_min in O(1). 
 * Would that be elegantly possible too?
 * 
 * �����Ŀ -  Sliding Window Maximum
 */

/**
 * 使用2个stack,其中一个用来维护最小值
 */
public class MinStack {
    Stack<Integer> storage = new Stack<Integer>();
    Stack<Integer> currentMinStack = new Stack<Integer>();

    public void push(int x) {
        if (storage.isEmpty() || x <= currentMinStack.peek()) {
            currentMinStack.push(x);
        }
        storage.push(x);
    }

    public void pop() {
        if (storage.isEmpty())
            return;
        int x = storage.pop();
        if (x == currentMinStack.peek())
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
 �𰸽�����
Consider space-time tradeoff. 
How would you keep track of the minimums using extra space?
Make sure to consider duplicate elements.

O(n) runtime, O(n) space �C Extra stack:

Use an extra stack to keep track of the current minimum value. 
During the push operation we choose the new element or the current minimum, 
whichever that is smaller to push onto the min stack.

O(n) runtime, O(n) space �C Minor space optimization:

If a new element is larger than the current minimum, 
we do not need to push it on to the min stack. When we perform 
the pop operation, check if the popped element is the same as the 
current minimum. If it is, pop it off the min stack too.
 * 
 * */
