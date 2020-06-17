package com.richie.leetcode.medium;

import com.richie.leetcode.ListNode;

/**
 * @author Richie on 2020.06.15
 */
public class Medium_82 {
    /**
     * 删除排序链表中的重复元素 II
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中没有重复出现的数字。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: 1->2->3->3->4->4->5
     * 输出: 1->2->5
     * </p>
     *
     * <p>
     * 解答：
     * 创建一个哨兵节点指向头节点，然后让当前节点指向哨兵节点。迭代链表，判断当前节点的下个节点和下下个节点是否相等。如果相等说明存在重复元素，
     * 使用一个临时节点指向重复重复节点开头，通过 while 循环去重，结束时让当前节点指向重复节点的后继。最终返回哨兵的后继节点。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        // 1->1->1->2->3
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        ListNode listNode = deleteDuplicates(head);
        ListNode.printList(listNode);
    }

    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            if (current.next.val == current.next.next.val) {
                ListNode temp = current.next;
                while (temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;
                }
                current.next = temp.next;
            } else {
                current = current.next;
            }
        }
        return dummy.next;
    }
}
