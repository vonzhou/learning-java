package oj.leetcode;

import *;

/*
 * Given a linked list, return the node where the cycle begins. 
 * If there is no cycle, return null.
 * Follow up:
 * Can you solve it without using extra space?
 * 
 * �ؼ����ҵ��Ǹ�������
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
			return null;// �����ڻ�
		
		// �ֱ�ӿ�ͷ �� ����������ƶ� �ٴ�������ʱ�������ڵ㣬 ֤�������д��о�
		ListNode l1 = head, l2 = slow;
		while(l1 != l2){
			l1 = l1.next;
			l2 = l2.next;
		}
		
		return l1;
	}
}
