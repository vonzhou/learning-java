package oj.leetcode;


public class SwapNodesInPairs {
    public static ListNode createListFromArray(int[] arr) {
        ListNode head = null;
        for (int i = 0; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            node.next = head;
            head = node;
        }

        return head;
    }

    public static void showList(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);  // list header
        dummy.next = head;
        ListNode pre = dummy, p = head;
        while (p != null && p.next != null) {
            ListNode tmp = p.next;
            p.next = p.next.next;
            tmp.next = p;
            pre.next = tmp;

            pre = p;
            p = p.next;
        }
        return dummy.next;
    }

    // �}ĿҪ��������������Ȼֱ�ӽ���ֵ����ӿ�
    //You may not modify the values in the list, only nodes itself can be changed.
    public static ListNode swapPairs2(ListNode head) {
        ListNode p = head;
        while (p != null && p.next != null) {

            //swap(p.val, p.next.val);// ������������ΪJava�Ǵ�ֵ����
            int tmp = p.val;
            p.val = p.next.val;
            p.next.val = tmp;
            p = p.next.next;
        }
        return head;
    }

    public static void swap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 343, 45, 4, 6};
        ListNode list = createListFromArray(arr);
        showList(list);

        list = swapPairs(list);
        showList(list);

        list = swapPairs2(list);
        showList(list);
    }

}
