package com.richie.leetcode.easy;

/**
 * @author richie on 2018.06.24
 */
public class Easy_21 {
    /**
     * 合并两个有序链表
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
     * </p>
     *
     * <p>
     * 描述：将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * </p>
     *
     * <p>
     * 解答：(1）如果head1或head2为空链表，则直接返回另外一个链表；
     * （2）选择head1与head2链表当前节点值较小的节点，挂接到后并后的链表mergeHead；
     * （3）重复步骤2，直到链表head1或者head2遍历完成，未遍历完的链表，直接挂接到mergeHead的尾节点。
     * </p>
     */

    public static void main(String[] args) {
        // 输入：1->2->4, 1->3->4
        // 输出：1->1->2->3->4->4
        ListNode f1 = new ListNode(1);
        ListNode f2 = new ListNode(2);
        ListNode f4 = new ListNode(4);
        f1.next = f2;
        f2.next = f4;
        ListNode s1 = new ListNode(1);
        ListNode s2 = new ListNode(3);
        ListNode s3 = new ListNode(4);
        s1.next = s2;
        s2.next = s3;

        ListNode listNode = mergeTwoLists(f1, s1);
        System.out.println(listNode);
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode p = l1;
        ListNode q = l2;
        ListNode cur;
        if (l1.val <= l2.val) {
            cur = p;
            p = p.next;
        } else {
            cur = q;
            q = q.next;
        }
        ListNode head = cur;
        while (p != null && q != null) {
            if (p.val <= q.val) {
                cur.next = p;
                cur = p;
                p = p.next;
            } else {
                cur.next = q;
                cur = q;
                q = q.next;
            }
        }
        while (p != null) {
            cur.next = p;
            cur = p;
            p = p.next;
        }
        while (q != null) {
            cur.next = q;
            cur = q;
            q = q.next;
        }
        return head;
    }

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return String.valueOf(val) + " -> " + next;
        }
    }
}
