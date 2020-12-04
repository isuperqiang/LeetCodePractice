package com.richie.leetcode.easy;

import com.richie.leetcode.ListNode;

/**
 * @author richie on 2019.05.18
 */
public class Easy_141 {
    /**
     * 环形链表
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/linked-list-cycle/
     * </p>
     *
     * <p>
     * 描述：给定一个链表，判断链表中是否有环。
     * </p>
     *
     * <p>
     * 示例：
     * 输入：head = [3,2,0,4,2]
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     * </p>
     *
     * <p>
     * 解答：快慢指针
     * 慢指针每次移动一步，快指针每次移动两步。如果链表中存在环，那么两个指针必定相遇。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
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
        boolean hasCycle = new Easy_141().hasCycle(head);
        System.out.println(hasCycle);
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
