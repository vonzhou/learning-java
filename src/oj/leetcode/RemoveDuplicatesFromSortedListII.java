package oj.leetcode;



/*
 * Given a sorted linked list, delete all nodes that have duplicate numbers, 
 * leaving only distinct numbers from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * 
 */
public class RemoveDuplicatesFromSortedListII {
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
	
	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(head.val + 1);
		ListNode p = head;
		ListNode q = p.next;
		ListNode pre = dummy;
		
		while(p != null && q != null){
			while(q != null && q.val == p.val){
				ListNode tmp = q;
				q = q.next;
				tmp = null; //for garbage
			}
			
			p.next = q; // dedu
			p = q;
		}
		return head;
	}
	
}
