package com.richie.leetcode.offer;

import com.richie.leetcode.ListNode;

/**
 * @author Richie on 2020.12.23
 */
public class Offer_24 {
    /**
     * 反转链表
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
     * </p>
     *
     * <p>
     * 描述：
     * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
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
     *
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
        ListNode ans = new Offer_24().reverseList(head);
        ListNode.printList(ans);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
