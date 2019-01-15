package oj.leetcode;


/*
 * Given a linked list, return the node where the cycle begins. 
 * If there is no cycle, return null.
 * Follow up:
 * Can you solve it without using extra space?
 * 
 * 锟截硷拷锟斤拷锟揭碉拷锟角革拷锟斤拷锟斤拷锟斤拷
 */
public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		if(head == null)
			return null;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode slow = dummy, fast = dummy.next;
		while(slow.next != null && fast.next != null){
			if(slow == fast)
				break;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(slow != fast)
			return null;// 锟斤拷锟斤拷锟节伙拷
		
		// 锟街憋拷涌锟酵� 锟斤拷 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷贫锟� 锟劫达拷锟斤拷锟斤拷锟斤拷时锟斤拷锟斤拷锟斤拷锟节点， 证锟斤拷锟斤拷锟斤拷锟叫达拷锟叫撅拷
		ListNode l1 = head, l2 = slow;
		while(l1 != l2){
			l1 = l1.next;
			l2 = l2.next;
		}
		
		return l1;
	}
}
