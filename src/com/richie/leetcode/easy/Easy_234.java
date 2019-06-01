package com.richie.leetcode.easy;

import com.richie.leetcode.ListNode;

/**
 * @author richie on 2018.06.23
 */
public class Easy_234 {

    /**
     * 回文链表
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/palindrome-linked-list/description/
     * </p>
     *
     * <p>
     * 描述：判断一个链表是否为回文链表。
     * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     * </p>
     *
     * <p>
     * 解答：利用快慢指针法找到链表中点，然后将后半部分就地反转，分别再从头、中点遍历判断是否相等，该方法时间复杂度O(n)、空间复杂度O(1)。
     * 将整个过程划分成三个函数：查找链表中点函数、反转链表函数和比较函数。
     * </p>
     */

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        System.out.println(l1);
        boolean palindrome = isPalindrome(l1);
        System.out.println("palindrome: " + palindrome);
        // palindrome: false
    }

    private static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode middleNode = findMiddleNode(head);
        middleNode.next = reverseNode(middleNode.next);
        ListNode p = head;
        ListNode q = middleNode.next;
        while (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }

    private static ListNode findMiddleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode reverseNode(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

}
