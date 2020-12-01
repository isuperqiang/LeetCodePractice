package com.richie.leetcode.medium;

import com.richie.leetcode.ListNode;

/**
 * @author Richie on 2020.03.23
 */
public class Medium_19 {
    /**
     * 删除链表的倒数第N个节点
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * </p>
     *
     * <p>
     * 示例：
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 给定的 n 保证是有效的。你能尝试使用一趟扫描实现吗？
     * </p>
     *
     * <p>
     * 解答：快慢指针
     * 使用哑节点来简化极端情况，快指针先走 n+1 步，然后和慢指针一起走，当快指针走到尾的时候，慢指针正好位于倒数 n+1 的位置，删除慢指针的 next 结点即可。
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
        // 1->2->3->4->5, 1->2->3->5
        ListNode newHead = removeNthFromEnd(head, 2);
        ListNode.printList(newHead);
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

}
