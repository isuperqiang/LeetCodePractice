package com.richie.leetcode.medium;

import com.richie.leetcode.ListNode;

/**
 * @author Richie on 2019.08.25
 */
public class Medium_24 {
    /**
     * 两两交换链表中的节点
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * </p>
     *
     * <p>
     * 示例：
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     * </p>
     *
     * <p>
     * 解答：
     * - 迭代法：从 head 开始遍历，改变相邻节点和它们前后节点之间的关系。
     * - 递归法：先处理最后两个或一个节点，然后再从后往前处理每一对节点。
     * </p>
     */

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode.printList(head);
        ListNode result = swapPairs1(head);
        ListNode.printList(result);
    }

    private static ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        ListNode result = head.next;
        ListNode next;
        ListNode prev = null;
        while (curr != null && (next = curr.next) != null) {
            ListNode temp = next.next;
            next.next = curr;
            curr.next = temp;
            if (prev != null) {
                prev.next = next;
            }
            prev = curr;
            curr = temp;
        }
        return result;
    }

    private static ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs2(next.next);
        next.next = head;
        return next;
    }

}
