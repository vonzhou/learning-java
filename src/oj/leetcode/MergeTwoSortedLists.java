package oj.leetcode;


/**
 * 21
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {
    //AC
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        dummy.next = null;
        ListNode cur = dummy;
        ListNode p = l1, q = l2;
        while (p != null && q != null) {
            ListNode tmp;
            if (p.val < q.val) {
                tmp = p.next;
                p.next = cur.next;
                cur.next = p;
                p = tmp;
            } else {
                tmp = q.next;
                q.next = cur.next;
                cur.next = q;
                q = tmp;
            }
            cur = cur.next;
        }
        if (p != null)
            cur.next = p;
        if (q != null)
            cur.next = q;

        return dummy.next;
    }

    /**
     * AC
     * 递归的思想, 寻求不变量
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

}
