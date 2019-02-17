package oj.leetcode;

/**
 * 160. Intersection of Two Linked Lists
 * Created by vonzhou on 2019/2/17.
 */
public class IntersectionOfTwoLinkedLists {

    /**
     * AC
     * A,B如果长度不一样的话,较长的链表先略过一定的部分,然后2个链表共同前进,看节点是否一样
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int lenA = 0;
        int lenB = 0;

        ListNode p = headA;
        ListNode q = headB;

        while (p != null) {
            p = p.next;
            lenA++;
        }

        while (q != null) {
            q = q.next;
            lenB++;
        }

        int diff = 0;
        p = headA;
        q = headB;

        if (lenA > lenB) {
            diff = lenA - lenB;
            int i = 0;
            while (i < diff) {
                p = p.next;
                i++;
            }
        } else {
            diff = lenB - lenA;
            int i = 0;
            while (i < diff) {
                q = q.next;
                i++;
            }
        }

        while (p != null && q != null) {
            if (p == q) {
                return p;
            }

            p = p.next;
            q = q.next;
        }

        return null;
    }
}
