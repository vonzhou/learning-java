package oj.leetcode;


/**
 * @author vonzhou
 * @date 2019/1/15
 */
public class ListUtil {
    public static void showList(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }
}
