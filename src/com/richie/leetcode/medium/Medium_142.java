package com.richie.leetcode.medium;

import com.richie.leetcode.ListNode;

/**
 * @author Richie on 2020.05.20
 */
public class Medium_142 {
    /**
     * 环形链表 II
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回 null。
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     * 说明：不允许修改给定的链表。
     * </p>
     *
     * <p>
     * 示例：
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：返回索引为 1 的链表节点
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     * </p>
     *
     * <p>
     * 解答：快慢指针
     * 使用快慢指针从头遍历链表，如果两个指针相遇则表示链表有环。然后让快指针从头开始，慢指针继续向前，两个指针再次相遇点就是环的入口。
     * </p>
     *
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode ln2 = new ListNode(2);
        head.next = ln2;
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = ln2;
        ListNode listNode = new Medium_142().detectCycle(head);
        System.out.println(listNode);
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
