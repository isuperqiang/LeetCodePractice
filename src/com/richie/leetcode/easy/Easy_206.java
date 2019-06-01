package com.richie.leetcode.easy;

import com.richie.leetcode.ListNode;

/**
 * @author richie on 2018.06.15
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
     * 解答：采用迭代法，从头节点开始，依次记录当前节点和其指向的下一个节点，并且保存指向后续节点的指针，然后把节点间的指向关系进行反转。
     * 采用递归法：把反转 1...n 看作反转 1 -> {n}，{n} 是已经反转的链表，然后反转 {n} 中的链表。
     * </p>
     */

    public static void main(String[] args) {
        ListNode l3 = new ListNode(3);
        l3.next = null;
        ListNode l2 = new ListNode(2);
        l2.next = l3;
        ListNode l1 = new ListNode(1);
        l1.next = l2;
        System.out.println("before: " + l1);
        // 1->2->3->null
        ListNode reverseList = reverseListByIterative(l1);
        System.out.println("after: " + reverseList);
        // 3->2->1->null
    }

    // 迭代解法
    private static ListNode reverseListByIterative(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode q = head.next;
        ListNode r;
        head.next = null;
        while (q != null) {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        head = p;
        return head;
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
