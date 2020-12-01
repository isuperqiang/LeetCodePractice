package com.richie.leetcode.offer;

import com.richie.leetcode.ListNode;

/**
 * @author Richie on 2020.12.01
 */
public class Offer_22 {
    /**
     * 链表中倒数第 k 个节点
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
     * </p>
     *
     * <p>
     * 描述：
     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
     * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
     * </p>
     *
     * <p>
     * 示例：
     * 给定一个链表: 1->2->3->4->5, 和 k = 2.
     * 返回链表 4->5.
     * </p>
     *
     * <p>
     * 解答：快慢指针
     * 快指针先走 k 步，然后和慢指针同速走。当快指针到达末尾，慢指针就是倒数第 k 个节点。
     * </p>
     *
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode kthFromEnd = new Offer_22().getKthFromEnd(head, 2);
        ListNode.printList(kthFromEnd);
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (k-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
