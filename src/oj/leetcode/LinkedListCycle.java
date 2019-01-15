package oj.leetcode;


/*
 * Given a linked list, determine if it has a cycle in it.
 * Follow up:
 * Can you solve it without using extra space?
 * 
 * ��ָ�룬�����������ѭ����������ֹ��������������β
 */
public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		if(head == null)
			return false;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode slow = dummy, fast = dummy.next;
		while(slow.next != null && fast.next != null && fast.next.next != null){
			if(slow == fast)
				return true;
			slow = slow.next;
			fast = fast.next.next;
		}
		return false;
	}
}
