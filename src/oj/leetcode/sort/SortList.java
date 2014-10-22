package oj.leetcode.sort;


/*
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * 时间复杂度为 nlogn 的排序算法就是归并 和 快排，单链表适合前者，双链表适合快排
 * 归并链表很简单，关键在每次对半分割子链表
 */
public class SortList {
	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode slow = head, fast = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		fast = slow;
		slow = slow.next;
		fast.next = null;  // 断开
		
		ListNode left = sortList(head);
		ListNode right = sortList(slow);
		return mergeTwoLists(left, right);
	}

	//这里的循环控制比 MergeTwoSortedLists.java 中更加简洁
	public ListNode mergeTwoLists(ListNode p, ListNode q) {
		ListNode dummy = new ListNode(-1);
		dummy.next = null;
		ListNode cur = dummy;
		while(p != null || q != null){
			int v1 = p==null ? Integer.MAX_VALUE:p.val;
			int v2 = q==null ? Integer.MAX_VALUE:q.val;
			ListNode tmp;
			if(v1 < v2){
				tmp = p.next;
				p.next = cur.next;
				cur.next = p;
				p = tmp;
			}else{
				tmp = q.next;
				q.next = cur.next;
				cur.next = q;
				q = tmp;
			}
			cur = cur.next;
		}
		
		return dummy.next;
	}	
	
}
