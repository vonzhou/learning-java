package oj.leetcode.linklist;

/*
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain
 *  a single digit. Add the two numbers and return it as a linked list.
 *  Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *  Output: 7 -> 0 -> 8
 *  
 *  题目似曾相识，这里是用链表，而不是数组，原理一样。
 *  一次性AC
 *  
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		// 之和
		ListNode dummy = new ListNode(-1);
		dummy.next = null;
		ListNode cur = dummy;
		// 处理进位
		int carry = 0;
		ListNode p = l1, q = l2;
		while(p != null && q != null){
			int sum = p.val + q.val + carry;
			if(sum >= 10){
				sum  = sum - 10;
				carry = 1;
			}else{
				carry = 0;
			}
			ListNode node = new ListNode(sum);
			node.next = cur.next;
			cur.next = node;
			cur = node;
			
			p = p.next;
			q = q.next;
		}
		while(p != null){
			int sum = p.val + carry;
			if(sum >= 10){
				sum  = sum - 10;
				carry = 1;
			}else{
				carry = 0;
			}
			ListNode node = new ListNode(sum);
			node.next = cur.next;
			cur.next = node;
			cur = node;
			
			p = p.next;
		}
		// or
		while(q != null){
			int sum = q.val + carry;
			if(sum >= 10){
				sum  = sum - 10;
				carry = 1;
			}else{
				carry = 0;
			}
			
			ListNode node = new ListNode(sum);
			node.next = cur.next;
			cur.next = node;
			cur = node;
			
			q = q.next;
		}
		// 处理最后一个节点的情况
		if(carry == 1){
			ListNode node = new ListNode(carry);
			node.next = cur.next;
			cur.next = node;
			cur = node;
		}
		return dummy.next;
	}
	public static ListNode createListFromArray(int[] arr){
		ListNode head = null;
		for(int i = 0; i < arr.length; i++){
			ListNode node = new ListNode(arr[i]);
			node.next = head;
			head = node;
		}
		
		return head;
	}
	public static void showList(ListNode head){
		ListNode p = head;
		while(p != null){
			System.out.print(p.val + " ");
			p = p.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int arr1[] = {2,4,3};
		int arr2[] = {5,6,7};
		ListNode a = createListFromArray(arr1);
		ListNode b = createListFromArray(arr2);
		AddTwoNumbers atn = new AddTwoNumbers();
		ListNode sum = atn.addTwoNumbers(a, b);
		showList(sum);
	}
}
