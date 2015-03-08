package oj.leetcode.tree;


class ComplexListNode{
	int val;
	ComplexListNode next;
	ComplexListNode sibling;
}

public class CopyComplexList {
	
	public ComplexListNode clone(ComplexListNode head){
		if(head == null || head.next == head)
			return head;
		head = doubleNodes(head);
		connectSiblings(head);
		splitTwo(head);
		return splitTwo(head);
	}

	// split by next pointers
	public ComplexListNode splitTwo(ComplexListNode head) {
		ComplexListNode p = head;
		ComplexListNode pclone = null;
		ComplexListNode cloneNode  = null;
		if(p != null){
			pclone = cloneNode = p.next;
			p.next = cloneNode.next;
			p = p.next;
		}
		while(p != null){
			cloneNode.next = p.next;
			cloneNode = cloneNode.next;
			p.next = cloneNode.next;
			p = p.next;
		}
		return pclone;
	}

	public ComplexListNode doubleNodes(ComplexListNode head) {
		ComplexListNode p = head;
		while(p != null){
			ComplexListNode cloneNode = new ComplexListNode();
			cloneNode.val = p.val;
			cloneNode.next = p.next;
			cloneNode.sibling = null;
			
			p.next = cloneNode;
			p = cloneNode.next;
		}
		return head;
	}
	
	public void connectSiblings(ComplexListNode head){
		ComplexListNode p = head;
		while(p != null){
			ComplexListNode cloneNode = p.next;
			if(p.sibling != null)
				cloneNode.sibling = p.sibling.next;
			
			p = cloneNode.next;
		}
	}
	

}
