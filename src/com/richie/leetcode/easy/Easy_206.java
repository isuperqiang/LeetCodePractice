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
     * 地址：https://leetcode-cn.com/problems/reverse-linked-list/
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
     * - 迭代法：从头节点开始迭代，保存前向节点和后继节点，反转节点的指向。
     * - 递归法：把反转 1...n 看作反转 1 -> {n}，{n} 是已经反转的链表，然后反转 {n} 中的链表。
     * </p>
     *
     * <p>
     * 递归：
     * - 时间复杂度：O(n)
     * - 空间复杂度：O(n)
     * 迭代：
     * - 时间复杂度：O(n)
     * - 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode reverseList = new Easy_206().reverseList(head);
        ListNode.printList(reverseList); // 5 -> 4 -> 3 -> 2 -> 1
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public ListNode reverseListByRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseListByRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
