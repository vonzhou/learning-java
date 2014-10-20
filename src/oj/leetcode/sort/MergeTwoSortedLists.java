package oj.leetcode.sort;


/*
 * Merge two sorted linked lists and return it as a new list.
 *  The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {
	////////////////
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		dummy.next = null;
		ListNode cur = dummy;
		ListNode p = l1, q = l2;
		while(p != null && q != null){
			ListNode tmp;
			if(p.val < q.val){
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
		if(p != null)
			cur.next = p;
		if(q != null)
			cur.next = q;
		
		return dummy.next;
	}

}
