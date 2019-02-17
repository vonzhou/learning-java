package oj.leetcode;

import java.util.Stack;

/**
 * Created by vonzhou on 2019/2/17.
 */
public class MinStack2 {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();

    public void push(int x) {
        // only push the old minimum value when the current
        // minimum value changes after pushing the new value x
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value,
        // pop twice and change the current minimum value to the last minimum value.
        if (stack.pop() == min)
            min = stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
