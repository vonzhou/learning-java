package oj.leetcode.linklist;

/**
 * 23. Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/
 *
 * @author vonzhou
 * @date 2019/1/15
 */
public class MergeKSortedLists {

    /**
     * 递归的方式
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        return partion(lists, 0, lists.length - 1);
    }

    public ListNode partion(ListNode[] lists, int s, int e) {
        if (s == e) return lists[s];
        if (s < e) {
            int q = (s + e) / 2;
            ListNode l1 = partion(lists, s, q);
            ListNode l2 = partion(lists, q + 1, e);
            return merge(l1, l2);
        } else
            return null;
    }

    //This function is from Merge Two Sorted Lists.
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


    /**
     * AC
     * 串行merge
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length <= 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        ListNode tmp = null;
        for (int i = 0; i < lists.length; i++) {
            tmp = mergeTwoLists(tmp, lists[i]);
        }


        return tmp;
    }

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
}
