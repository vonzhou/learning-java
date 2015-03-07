package oj.swordoffer;

public class ReverseList {

	// change the next pointer of all the list nodes
	public static ListNode reverseList1(ListNode list) {
		ListNode tail = null;
		ListNode traverse = list;
		ListNode pre = null;
		
		while(traverse != null){
			ListNode tempNext = traverse.next;
			if(tempNext == null)
				tail = traverse;
			traverse.next = pre;
			
			pre = traverse;
			traverse = tempNext;
		}

		return tail;
	}

	// my head insert
	public static ListNode reverseList2(ListNode list) {

		return null;
	}

	// recursively
	public static ListNode reverseList3(ListNode list) {

		return null;
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7};
		ListNode list = ListUtil.createListFromArray2(a);
		list = reverseList1(list);
		ListUtil.showList(list);
	}

}
