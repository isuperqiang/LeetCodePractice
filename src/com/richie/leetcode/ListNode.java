package com.richie.leetcode;

/**
 * Definition for singly-linked list.
 *
 * @author richie on 2019.06.01
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("Null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(head.val).append(" -> ");
        ListNode listNode = head;
        while ((listNode = listNode.next) != null) {
            sb.append(listNode.val).append(" -> ");
        }
        sb.delete(sb.length() - 4, sb.length());
        System.out.println(sb);
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }

}
