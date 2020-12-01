package com.richie.leetcode.easy;

import com.richie.leetcode.ListNode;

/**
 * @author richie on 2019.05.05
 */
public class Easy_160 {
    /**
     * 相交链表
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
     * </p>
     *
     * <p>
     * 描述：编写一个程序，找到两个单链表相交的起始节点。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: 9->1->2->4, 3->2->4
     * 输出: 2
     * </p>
     *
     * <p>
     * 解答：定义两个指针, 第一轮让到达末尾的节点指向另一个链表的头部, 最后两个指针相遇点即为起始交点。
     * 两个指针移动了相同的距离, 有交点就结束, 无交点就各走了两条指针的长度。
     * </p>
     *
     * <p>
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        ListNode headA = new ListNode(9);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(2);
        headA.next.next.next = new ListNode(4);
        ListNode headB = new ListNode(3);
        headB.next = new ListNode(2);
        headB.next.next = new ListNode(4);
        ListNode intersectionNode = new Easy_160().getIntersectionNode(headA, headB);
        System.out.println(intersectionNode); // 1
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode ha = headA;
        ListNode hb = headB;
        while (ha != hb) {
            ha = ha == null ? headB : ha.next;
            hb = hb == null ? headA : hb.next;
            if (ha != null && hb != null && ha.val == hb.val) {
                break;
            }
        }
        return ha;
    }
}
