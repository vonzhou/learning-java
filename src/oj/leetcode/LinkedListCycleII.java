package oj.leetcode;


/*
 * Given a linked list, return the node where the cycle begins. 
 * If there is no cycle, return null.
 * Follow up:
 * Can you solve it without using extra space?
 * 
 */
public class LinkedListCycleII {

    /**
     * AC
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                ListNode slow2 = head;
                while (slow2 != slow) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }

    /**
     * AC
     * 分析:先利用双指针的方法,判断是否有环,找到slow,fast指针相遇的地方,然后分析入口的位置
     * 假设链表头到环入口的距离是A, 假设碰撞之前slow迭代的距离是 A+B,那么fast跑的距离是 2(A+B),假设环的大小是N
     * 可以得到:  A  +  B  + N = 2(A+B)
     * A + B = N 所以链表头到入口的距离,和碰撞点到入口的距离一样!
     *
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        if (head == null)
            return null;
        ListNode slow = head, fast = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }

        }

        // 移动后,slow==fast才可认为有环
        if (!hasCycle)
            return null;


        // slow, fast 碰撞的地方不一定就是环的入口
        ListNode l1 = head;
        while (l1 != slow) {
            l1 = l1.next;
            slow = slow.next;
        }

        return l1;
    }

}
