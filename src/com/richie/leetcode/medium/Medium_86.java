package com.richie.leetcode.medium;

import com.richie.leetcode.ListNode;

/**
 * @author Richie on 2020.11.01
 */
public class Medium_86 {
    /**
     * 分隔链表
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/partition-list/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
     * 你应当保留两个分区中每个节点的初始相对位置。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: head = 1->4->3->2->5->2, x = 3
     * 输出: 1->2->2->4->3->5
     * </p>
     *
     * <p>
     * 解答：双指针
     * 初始化两个指针和哑节点，分别指向小于 x 和大于等于 x 的链表，遍历原链表，比较当前节点值与特定值的大小，决定拼接在哪个指针后面。
     * 遍历结束后，将后半部分的 next 置空，连接前半部分和后半部分，返回哑节点的 next。
     * </p>
     *
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        ListNode listNode = new Medium_86().partition(head, 3);
        ListNode.printList(listNode);
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyBefore = new ListNode(0);
        ListNode dummyAfter = new ListNode(0);
        ListNode before = dummyBefore;
        ListNode after = dummyAfter;
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next = null;
        before.next = dummyAfter.next;
        return dummyBefore.next;
    }
}
