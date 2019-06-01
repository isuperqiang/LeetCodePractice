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
     * <p>
     * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     * <p>
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * </p>
     *
     * <p>
     * 解答：
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
        System.out.println(listNode);
        //
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }

        int r1 = getNodeValue(l1);
        int r2 = getNodeValue(l2);
        int r = r1 + r2;
        int t = 0;
        int k = r;
        while (k > 0) {
            k /= 10;
            t++;
        }
        ListNode l = null;
        while (t > 0) {
            t--;
            double pow = Math.pow(10, t);
            int a = (int) (r / pow);
            r = (int) (r - a * pow);
            ListNode tmp = l;
            l = new ListNode(a);
            l.next = tmp;
        }
        return l;
    }

    private static int getNodeValue(ListNode listNode) {
        int var = listNode.val;
        ListNode next = listNode.next;
        while (next != null) {
            var = var * 10 + next.val;
            next = next.next;
        }
        return var;
    }
}
