package oj.leetcode;



/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class InsertionSortList {
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

	// û��ͷ�ڵ㣬������������
	public static ListNode insertionSortList2(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode p = head.next;
		ListNode list = head; // construct a new list
		list.next = null;
		ListNode lo = list, pre = list;
		
		while(p != null){
			
			ListNode q = p;
			p = p.next;
			while(lo!= null && q.val > lo.val){
				pre = lo;
				lo = lo.next;
			}
			System.out.println("---------");
			q.next = lo;
			pre.next = q;   //insert
			
			lo = list; //next round
			pre=list;
		}

		return list;
	}
	
	public static ListNode insertionSortList(ListNode head) {
		ListNode list = new ListNode(0);  //ͷ�ڵ�
		while(head != null){
			ListNode node = list;
			while(node.next != null && node.next.val < head.val)
				node = node.next;
			
			ListNode tmp = head.next;
			head.next = node.next;
			node.next = head;
			
			head = tmp;
		}
		
		return list.next;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,45,78,23,100,0,33,56,13,};
		ListNode list =createListFromArray(arr);
		showList(list);
		list = insertionSortList(list);
		showList(list);
	}
	
	
	
	
	
	
}
