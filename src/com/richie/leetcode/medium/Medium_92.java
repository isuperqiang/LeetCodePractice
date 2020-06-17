package com.richie.leetcode.medium;

import com.richie.leetcode.ListNode;

/**
 * @author Richie on 2020.06.17
 */
public class Medium_92 {
    /**
     * 反转链表 II
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/reverse-linked-list-ii/
     * </p>
     *
     * <p>
     * 描述：
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     * 1 ≤ m ≤ n ≤ 链表长度。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     * </p>
     *
     * <p>
     * 解答：
     * 首先记录要反转节点起始位置的前一个节点，然后反转 m-n 区间的链表，最后修改起始前一个节点和起始节点的指针。
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
        ListNode listNode = reverseBetween(head, 2, 4);
        ListNode.printList(listNode);
    }

    private static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        for (int i = 1; i < m; i++) {
            current = current.next;
        }
        ListNode startPrev = current;
        current = current.next;
        ListNode previous = null;
        ListNode next = null;
        for (int i = m; i <= n; i++) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        startPrev.next.next = next;
        startPrev.next = previous;
        return dummy.next;
    }
}
