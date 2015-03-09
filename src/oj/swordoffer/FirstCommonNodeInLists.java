package oj.swordoffer;

public class FirstCommonNodeInLists {
	/*
	 * 1.Brute 每遍历L1的一个节点 就遍历L2看是否经过这个节点  O(mn)
	 */
	
	/*
	 * 2. 利用两个辅助栈 然后从链表尾部开始弹出 最后一个相同的节点就是
	 * O(m+n) , 空间复杂度O(m+n)
	 */
	
	/*
	 * 3. 先得到两个链表长度之差k，然后让长者先走k步  然后同时遍历L1 L2 ，O(m+n)
	 */
	public ListNode firstCommon(ListNode head1, ListNode head2){
		if(head1 == null || head2== null)
			return null;
		int len1 = getListLen(head1);
		int len2 = getListLen(head2);
		
		int dif = len1 - len2;
		
		ListNode fast = head1;
		ListNode slow = head2;
		
		if(len2 > len1){
			fast = head2;
			slow = head1;
			dif = len2 - len1;
		}
		
		// the long list ,go dif steps first
		for(int i=0; i<dif; i++)
			fast = fast.next;
		
		while(fast!=null && slow!=null && fast!=slow){
			fast = fast.next;
			slow = slow.next;
		}
		
		ListNode res = fast;
		return res;
	}

	public int getListLen(ListNode head1) {
		ListNode p = head1;
		int count =0;
		while(p!=null){
			count ++;
			p = p.next;
		}
		return count;
	}

}
