package com.richie.leetcode.medium;

import com.richie.leetcode.ListNode;

/**
 * @author richie on 2018.07.15
 */
public class Medium_2 {
    /**
     * 两数相加
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/add-two-numbers/
     * </p>
     *
     * <p>
     * 描述：
     * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     * </p>
     *
     * <p>
     * 示例：
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * </p>
     *
     * <p>
     * 解答：由于链表存储是从低位到高位顺序，从头开始遍历两个链表，取得每个节点对应的值然后相加。存在链表长度不一样的情况，这时候把加数当作零。
     * 使用一个变量记录进位，在下次求和时加上进位。在遍历结束后，也要检查进位情况。
     * </p>
     *
     * <p>
     * 时间复杂度：O(max(m,n))
     * 空间复杂度：O(max(m,n))
     * </p>
     */

    public static void main(String[] args) {
        ListNode l2 = new ListNode(2);
        ListNode l4a = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l2.next = l4a;
        l4a.next = l3;
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l4b = new ListNode(4);
        l5.next = l6;
        l6.next = l4b;

        ListNode listNode = addTwoNumbers(l2, l5);
        ListNode.printList(listNode); // 7->0->8
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode curr = dummy;
        int carry = 0;
        while (p != null || q != null) {
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummy.next;
    }

}
