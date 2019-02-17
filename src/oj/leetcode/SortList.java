package oj.leetcode;

/**
 * 148. Sort List
 * 如果没有空间复杂度O(1)的要求,可以直接使用库函数排序
 * Created by vonzhou on 2019/2/17.
 */
public class SortList {

    /**
     * AC
     */
    public ListNode sortList(ListNode head) {
        return mergeSortList(head);
    }

    // 归并排序
    public ListNode mergeSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // 计算链表长度
        int L = 0;
        ListNode p = head;
        while (p != null) {
            L++;
            p = p.next;
        }

        int mid = L / 2;

        ListNode l = head, r = null;

        // 将 r 指向链表的中间mid
        p = head;
        int i = 0;
        while (p != null) {
            i++;
            ListNode tmp = p.next;

            // 链表在此处断裂
            if (i == mid) {
                p.next = null;
                r = tmp;
            }
            p = tmp;
        }

        // 递归排序左右部分,然后归并
        ListNode h1 = mergeSortList(l);
        ListNode h2 = mergeSortList(r);
        ListNode merged = merge(h1, h2);

        return merged;
    }

    public ListNode merge(ListNode l1, ListNode l2) {
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


}
