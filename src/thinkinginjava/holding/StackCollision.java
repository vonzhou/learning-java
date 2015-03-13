package thinkinginjava.holding;

public class StackCollision {
	public static void main(String[] args) {
		thinkinginjava.util.Stack<String> stack = new thinkinginjava.util.Stack<String>();
		for (String s : "My dog has fleas".split(" "))
			stack.push(s);
		while (!stack.empty())
			System.out.print(stack.pop() + " ");
		System.out.println();
		
		java.util.Stack<String> stack2 = new java.util.Stack<String>();
		for (String s : "My dog has fleas".split(" "))
			stack2.push(s);
		System.out.println(stack2.get(2)); // 不应该表现出这种行为
		while (!stack2.empty())
			System.out.print(stack2.pop() + " ");
	}
}