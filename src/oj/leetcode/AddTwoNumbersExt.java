package oj.leetcode;

/**
 * 用单向链表表示十进制整数，求两个正整数的和。
 * 如下所示(1234 + 234 = 1468)：
 * 1->2->3->4 +    2->3->4 = 1->4->6->8  请注意单向链表的方向。  不允许使用其他数据结构。 
 * 8 6 4 1
 * Created by vonzhou on 2019/2/20.
 */
public class AddTwoNumbersExt {
    ListNode add(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode dummy = new ListNode(0);
        list1 = reverse(list1);
        list2 = reverse(list2);
        ListNode p = list1, q = list2;
        int carry = 0;
        while (p != null && q != null) {
            ListNode t1 = p.next, t2 = q.next;
            int sum = p.val + q.val + carry;
            ListNode newN = new ListNode(sum % 10);
            newN.next = dummy.next;
            dummy.next = newN;
            carry = sum / 10;

            p = t1;
            q = t2;
        }


        while (p != null) {
            ListNode t1 = p.next;
            int sum = p.val + carry;
            ListNode newN = new ListNode(sum % 10);
            newN.next = dummy.next;
            dummy.next = newN;
            carry = sum / 10;

            p = t1;
        }

        while (q != null) {
            ListNode t1 = q.next;
            int sum = q.val + carry;
            ListNode newN = new ListNode(sum % 10);
            newN.next = dummy.next;
            dummy.next = newN;
            carry = sum / 10;

            q = t1;
        }

        // 别忘了,如果最后有进位
        if (carry == 1) {
            ListNode newN = new ListNode(1);
            newN.next = dummy.next;
            dummy.next = newN;
        }


        // 上面构造的时候是往链表头部插的,所以,这里不需要再次reverse了,fuck
        return dummy.next;
    }

    private ListNode reverse(ListNode list1) {
        if (list1 == null) {
            return null;
        }

        ListNode d = new ListNode(0);
        ListNode p = list1;
        while (p != null) {
            ListNode tmp = p.next;
            p.next = d.next;
            d.next = p;
            p = tmp;
        }

        return d.next;
    }

    public static void main(String[] args) {
        ListNode l1 = Util.createListFromArray(new int[]{1, 2, 3, 4});
        ListNode l2 = Util.createListFromArray(new int[]{2, 3, 4});
        Util.showList(new AddTwoNumbersExt().add(l1, l2));


        l1 = Util.createListFromArray(new int[]{8, 3, 4});
        l2 = Util.createListFromArray(new int[]{2, 3, 4});
        Util.showList(new AddTwoNumbersExt().add(l1, l2));


        l1 = Util.createListFromArray(new int[]{8, 3, 6});
        l2 = Util.createListFromArray(new int[]{2, 3, 4});
        Util.showList(new AddTwoNumbersExt().add(l1, l2));
    }
}
