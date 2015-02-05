package oj.swordoffer;

import java.util.Stack;

/**
 * 5.从后往前输出一个链表的序列
 * @author vonzhou
 *
 */
public class PrintListReversely {
	
	// using a Stack
	public static void printListReversely(ListNode list){
		ListNode head = list.next;
		if(head == null)
			return;
		Stack<Integer> stack = new Stack<Integer>();
		while(head != null){
			stack.push(head.val);
			head = head.next;
		}
		while(!stack.empty()){
			System.out.print(stack.pop() + " ");
		}
		System.out.println();
	}
	
	// recursive
	public static void printListReversely2(ListNode list){
		ListNode head = list.next;
		if(head == null)
			return;
		printRecursive(head);
		System.out.println();
	}
	public static void printRecursive(ListNode list){
		if(list.next == null)
			System.out.print(list.val + " ");
		else {
			printRecursive(list.next);
			System.out.print(list.val + " ");
		}
	}
	// construct another list(reverse)
	// .......
	
	public static void main(String[] args) {
		int arr[] = {2,345,88,9,0,234,67};
		int case2[] = {};
		ListNode list = ListUtil.createListFromArray(arr);
		printListReversely2(list);
	}
	

}
