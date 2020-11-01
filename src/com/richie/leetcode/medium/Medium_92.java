package com.richie.leetcode.medium;

import com.richie.leetcode.ListNode;

/**
 * @author Richie on 2020.06.17
 */
public class Medium_92 {
    /**
     * 反转链表 II
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/reverse-linked-list-ii/
     * </p>
     *
     * <p>
     * 描述：
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     * 说明：1 ≤ m ≤ n ≤ 链表长度。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     * </p>
     *
     * <p>
     * 解答：
     * 存在头节点被反转的可能，使用哑节点指向头节点，结果返回哑节点的 next。
     * 保存要反转的起始节点和前一个节点，然后反转 m-n 区间的链表，修改起始节点和前一个节点的指针。
     * </p>
     *
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * </p>
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = new Medium_92().reverseBetween(head, 2, 4);
        ListNode.printList(listNode); // 1 -> 4 -> 3 -> 2 -> 5
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m < 1 || n < m) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        ListNode mPrev = null;
        for (int i = 0; i < m; i++) {
            mPrev = curr;
            curr = curr.next;
        }
        ListNode mCurr = curr;
        ListNode prev = null;
        for (int i = m; i <= n; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        mCurr.next = curr;
        mPrev.next = prev;
        return dummy.next;
    }
}
