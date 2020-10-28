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
     * - 迭代
     * 创建一个哑节点指向头节点，令当前节点 curr 指向哑节点。从头开始迭代链表，比较当前节点的下个节点和下下个节点是否相等。
     * 如果相等，说明存在重复元素，使用一个临时节点 temp 指向重复节点的开头，通过 while 循环去重，循环结束时 temp 指向重复节点的结尾。
     * 令当前节点指向重复节点的后继就实现了消除重复元素。如果不相等，则继续向后迭代。最后返回哑节点的后继节点。
     * - 递归
     * 如果当前节点和下个节点值相等，通过 while 循环去重，令当前节点指向重复节点的结尾，处理当前节点的下个节点。
     * 否则，处理当前节点的下个节点，令当前节点指向递归函数返回值。
     * </p>
     *
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        ListNode listNode = new Medium_82().deleteDuplicates(head);
        ListNode.printList(listNode); // 2 -> 3
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val == curr.next.next.val) {
                ListNode temp = curr.next;
                while (temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;
                }
                curr.next = temp.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates2(head.next);
            return head;
        }
    }
}
