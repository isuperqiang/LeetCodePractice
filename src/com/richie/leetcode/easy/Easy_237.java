package com.richie.leetcode.easy;

/**
 * @author richie on 2018.06.01
 */
public class Easy_237 {

    /**
     * 删除链表的结点
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/delete-node-in-a-linked-list/description/
     * </p>
     *
     * <p>
     * 描述：请编写一个函数，使其可以删除某个链表中给定的（非末尾的）节点，您将只被给予要求被删除的节点。
     * 比如：假设该链表为 1 -> 2 -> 3 -> 4  ，给定您的为该链表中值为 3 的第三个节点，那么在调用了您的函数之后，该链表则应变成 1 -> 2 -> 4 。
     * </p>
     *
     * <p>
     * 解答：给定了要被删除的节点，而单向链表又无法回溯，因此可以将下一个节点删除，并将值赋给要被删除的节点，这样也可以算作删除了给定的节点。
     * </p>
     */

    public static void main(String[] args) {
        //1 -> 2 -> 3 -> 4
        ListNode listNode4 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        listNode3.next = listNode4;
        ListNode listNode2 = new ListNode(2);
        listNode2.next = listNode3;
        ListNode listNode1 = new ListNode(1);
        listNode1.next = listNode2;

        System.out.println(listNode1);
        // 1 -> 2 -> 3 -> 4 -> null
        deleteNode(listNode2);
        System.out.println(listNode1);
        // 1 -> 3 -> 4 -> null
    }

    private static void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }

        ListNode next = node.next;
        node.next = next.next;
        node.val = next.val;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return String.valueOf(val) + " -> " + next;
        }
    }
}
