package com.richie.leetcode.easy;

import com.richie.leetcode.ListNode;

/**
 * @author Richie on 2018.06.15
 */
public class Easy_206 {
    /**
     * 反转链表
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/reverse-linked-list/description/
     * </p>
     *
     * <p>
     * 描述：反转一个单链表
     * 进阶: 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     * </p>
     *
     * <p>
     * 示例：
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * </p>
     *
     * <p>
     * 解答：
     * 迭代法：从头节点开始，记录当前节点和其指向的下一个节点，并且保存指向后续节点的指针，然后把节点间的指向关系进行反转。
     * 递归法：把反转 1...n 看作反转 1 -> {n}，{n} 是已经反转的链表，然后反转 {n} 中的链表。
     * </p>
     *
     * <p>
     * 递归：
     * - 时间复杂度：O(N)
     * - 空间复杂度：O(N)
     * 迭代：
     * - 时间复杂度：O(N)
     * - 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode reverseList = reverseListByIterative(head);
        ListNode.printList(reverseList);
    }

    // 迭代解法
    private static ListNode reverseListByIterative(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }

    // 递归解法
    private static ListNode reverseListByRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseListByRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

}
