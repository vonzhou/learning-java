package oj.leetcode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 * Created by vonzhou on 2019/2/17.
 */
public class ReverseLinkedList {

    /**
     * AC
     * 简单
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dumy = new ListNode(0);
        dumy.next = null;

        ListNode p = head;
        while (p != null) {
            ListNode tmp = p.next;
            p.next = dumy.next;
            dumy.next = p;
            p = tmp;
        }

        return dumy.next;
    }
}
