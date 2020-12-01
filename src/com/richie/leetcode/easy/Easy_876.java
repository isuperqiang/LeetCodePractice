package com.richie.leetcode.easy;

import com.richie.leetcode.ListNode;

/**
 * @author Richie on 2020.03.23
 */
public class Easy_876 {
    /**
     * 链表的中间结点
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/middle-of-the-linked-list/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     * </p>
     *
     * <p>
     * 示例：
     * 输入：[1,2,3,4,5]
     * 输出：3
     * 给定链表的结点数介于 1 和 100 之间。
     * </p>
     *
     * <p>
     * 解答：快慢指针
     * 快指针每次走两步，慢指针每次走一步。两个指针从头开始走，当快指针走到尾的时候，慢指针正好处在中间位置。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        // 1->2->3->4->5, 3
        ListNode middleNode = middleNode(head);
        System.out.println(middleNode);
    }

    private static ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
