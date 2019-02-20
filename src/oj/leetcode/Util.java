package oj.leetcode;

/**
 * @author vonzhou
 * @date 2019/1/15
 */
public class Util {
    public static void printArr(int[] arr){
        if(arr != null){
            for(int i=0;i<arr.length;i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void showList(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static ListNode createListFromArray(int[] arr) {
        ListNode head = null;
        for (int i = arr.length-1; i >= 0; i--) {
            ListNode node = new ListNode(arr[i]);
            node.next = head;
            head = node;
        }

        return head;
    }
}
