package oj.leetcode.linklist;


/*
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 *    Given linked list: 1->2->3->4->5, and n = 2.
 *
 *   After removing the second node from the end, the linked list becomes 1->2->3->5.
 *   Note:
 *   Given n will always be valid.  不用判断n的有效性??
 *   Try to do this in one pass.
 */
public class RemoveNthNodeFromEndofList {
	
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

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null)
			return null;
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode p = dummy, q = head;
		for(int i = 0; i<n ; i++)
			q = q.next;
		
		while(q != null){
			p = p.next;
			q = q.next;
		}
		
		ListNode tmp = p.next;
		p.next = tmp.next;
		tmp = null; // delete
		
	   return dummy.next;     
	}
	public static void main(String[] args) {
		int[] arr = {1,45,78,23,100,0,33,56,13,};
		ListNode list =createListFromArray(arr);
		showList(list);
		list = removeNthFromEnd(list,2);
		showList(list);
	}
}








