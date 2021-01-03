package com.richie.leetcode.offer;

import com.richie.leetcode.ListNode;

/**
 * @author Richie on 2021.01.03
 */
public class Offer_18 {
    /**
     * 删除链表的节点
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
     * </p>
     *
     * <p>
     * 描述：
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     * 返回删除后的链表的头节点。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: head = [4,5,1,9], val = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     * </p>
     *
     * <p>
     * 解答：
     * 设定哑节点指向头节点，减少头节点被删除的判断。记录遍历的当前节点和前一个节点，如果当前节点值等于目标值，修改指针，跳出循环。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);
        ListNode ans = new Offer_18().deleteNode(head, 5);
        ListNode.printList(ans);
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;
        ListNode prev = dummy;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
                curr.next = null;
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        return dummy.next;
    }
}
