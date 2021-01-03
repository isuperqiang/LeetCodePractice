package com.richie.leetcode.offer;

import com.richie.leetcode.ListNode;

/**
 * @author Richie on 2021.01.03
 */
public class Offer_25 {
    /**
     * 合并两个排序的链表
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
     * </p>
     *
     * <p>
     * 描述：
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     * 0 <= 链表长度 <= 1000
     * </p>
     *
     * <p>
     * 示例：
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * </p>
     *
     * <p>
     * 解答：
     * 和题目 21 相同
     * </p>
     *
     * <p>
     * 时间复杂度：O(M+N)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        ListNode f1 = new ListNode(1);
        ListNode f2 = new ListNode(2);
        ListNode f4 = new ListNode(4);
        f1.next = f2;
        f2.next = f4;
        ListNode s1 = new ListNode(1);
        ListNode s2 = new ListNode(3);
        ListNode s3 = new ListNode(4);
        s1.next = s2;
        s2.next = s3;
        ListNode listNode = new Offer_25().mergeTwoLists(f1, s1);
        ListNode.printList(listNode);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
