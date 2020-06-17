package com.richie.leetcode.easy;

import com.richie.leetcode.ListNode;

/**
 * @author richie on 2019.05.04
 */
public class Easy_83 {
    /**
     * 删除排序链表中的重复元素
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
     * </p>
     *
     * <p>
     * 描述：给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: 1->1->2->3->3
     * 输出: 1->2->3
     * </p>
     *
     * <p>
     * 解答：从头开始遍历链表，比较前后两个节点元素的值。如果相等就修改前置指针，不相等就继续向后移动。
     * </p>
     */

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        ListNode listNode = deleteDuplicates(head);
        ListNode.printList(listNode); // 1, 2, 3
    }

    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prevNose = head;
        ListNode currNode = head;
        while ((currNode = currNode.next) != null) {
            if (prevNose.val == currNode.val) {
                prevNose.next = currNode.next;
            } else {
                prevNose = currNode;
            }
        }
        return head;
    }

}
