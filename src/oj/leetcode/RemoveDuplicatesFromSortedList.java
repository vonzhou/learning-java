package oj.leetcode;

/*
 * Given a *sorted* linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */

public class RemoveDuplicatesFromSortedList {
	
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
	
	// 迭代，一定要注意检查边界条件
	public static ListNode deleteDuplicates(ListNode head) {
		ListNode p = head, q;
		if(p == null || p.next == null)
			return head;
		q = head.next;
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
	/*
	// 递归实现   -- 有问题
	public static ListNode deleteDuplicates2(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(head.val + 1);
		// recursively dedu one
		dummy = recur(dummy,head);
		return dummy.next;
	}
	
	private static ListNode recur(ListNode pre, ListNode cur) {
		if(cur == null)
			return pre;
		if(cur.val == pre.val){
			ListNode tmp = cur;
			pre.next = cur.next;
			tmp = null;
			recur(pre, pre.next);
		}else{
			recur(pre.next, cur.next);
		}
		return pre;
	}
*/
	public static void main(String[] args) {
		int[] arr = {1,2,3,3,3,56,77,88,};
		ListNode list = createListFromArray(arr);
		showList(list);
		
		deleteDuplicates(list);
		showList(list);
	}
}














