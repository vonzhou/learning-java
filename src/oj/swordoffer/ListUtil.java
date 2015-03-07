package oj.swordoffer;

public class ListUtil {
	// construct a linked list with a dummy header
	public static ListNode createListFromArray(int[] arr){
		ListNode dummy = new ListNode(-1);
		dummy.next = null;
		if(arr == null || arr.length <=0)
			return dummy;
		ListNode tail = dummy;
		for(int i = 0; i < arr.length; i++){
			ListNode node = new ListNode(arr[i]);
			node.next = tail.next;
			tail.next = node;
			tail = node;
		}
		
		
		return dummy;
	}
	public static ListNode createListFromArray2(int[] arr){
		ListNode dummy = new ListNode(-1);
		dummy.next = null;
		if(arr == null || arr.length <=0)
			return dummy.next;
		
		ListNode tail = dummy;
		for(int i = 0; i < arr.length; i++){
			ListNode node = new ListNode(arr[i]);
			node.next = tail.next;
			tail.next = node;
			tail = node;
		}
		
		
		return dummy.next;
	}
	public static void showList(ListNode head){
		ListNode p = head.next;
		while(p != null){
			System.out.print(p.val + " ");
			p = p.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int arr[] = {2,345,88,9,0,234,67};
		ListNode list = createListFromArray(arr);
		showList(list);
	}
}
