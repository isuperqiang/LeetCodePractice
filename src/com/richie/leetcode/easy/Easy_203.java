package com.richie.leetcode.easy;

import com.richie.leetcode.ListNode;

/**
 * @author richie on 2019.06.01
 */
public class Easy_203 {
    /**
     * 移除链表元素
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/remove-linked-list-elements/
     * </p>
     *
     * <p>
     * 描述：删除链表中等于给定值 val 的所有节点。
     * <p>
     *
     * <p>
     * 示例：
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     * </p>
     *
     * <p>
     * 解答：
     * - 解法一：首先检查头结点，如果结点值与val相等，那么把头指针后移；然后遍历链表，如果当前结点值与val相等，那么将前一个结点的指针指向后一个结点。
     * - 解法二：递归。
     * </p>
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
        ListNode listNode = removeElements(head, 6);
        ListNode.printList(listNode);
    }

    private static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode curr = head;
        ListNode prev = curr;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }

    private static ListNode removeElementsRecursive(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElementsRecursive(head.next, val);
        return head.val == val ? head.next : head;
    }

}
