package com.richie.leetcode.easy;

import com.richie.leetcode.ListNode;

/**
 * @author richie on 2018.06.24
 */
public class Easy_21 {
    /**
     * 合并两个有序链表
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/merge-two-sorted-lists/
     * </p>
     *
     * <p>
     * 描述：
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * </p>
     *
     * <p>
     * 示例：
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * </p>
     *
     * <p>
     * 解答：
     * - 迭代
     * 1. 设定一个哨兵节点 dummy，方便返回合并后的链表。维护一个 prev 节点，不断调整它的 next 指针
     * 2. 如果 l1 节点的值小于 l2 节点的值，就让 prev 指向 l1，同时把 l1 指针后移；否则就移动 l2，prev 始终向后移动
     * 3. 重复步骤 2，直到 l1 或 l2 指向 null，此时 l1 或 l2 有一个非空，只需要把它添加到合并链表的后面
     * - 递归
     * 1. 终止条件：两条链表 l1 和 l2，当 l1 为空或 l2 为空时结束
     * 2. 返回值：每层调用都返回排序好的链表头
     * 3. 递归内容：如果 l1 的 val 值更小，则将 l1 的 next 与排序好的链表头相接，l2 同理
     * </p>
     *
     * <p>
     * - 迭代
     * 时间复杂度：O(m+n)，其中 m 和 n 分别为两个链表的长度
     * 空间复杂度：O(1)
     * - 递归
     * 时间复杂度：O(m+n)，其中 m 和 n 分别为两个链表的长度
     * 空间复杂度：O(m+n)
     * </p>
     */

    public static void main(String[] args) {
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
        ListNode listNode = new Easy_21().mergeTwoLists(f1, s1);
        ListNode.printList(listNode);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }
}
