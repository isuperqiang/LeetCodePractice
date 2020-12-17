package com.richie.leetcode.offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Richie on 2020.12.01
 */
public class Offer_09 {
    /**
     * 用两个栈实现队列
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
     * </p>
     *
     * <p>
     * 描述：
     * * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
     * * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
     * </p>
     *
     * <p>
     * 示例：
     * 输入：
     * ["CQueue","appendTail","deleteHead","deleteHead"]
     * [[],[3],[],[]]
     * 输出：[null,null,3,-1]
     * </p>
     *
     * <p>
     * 解答：
     * 维护两个栈，一个栈支持插入操作，另一个栈支持删除操作。往栈A 插入元素后，栈顶是尾部元素，栈底是头部元素；栈B 存储要删除的元素，
     * 栈顶是头部元素，栈底是尾部元素。当删除头部元素时，检查栈B 是否为空，如果非空，弹出栈顶元素；否则，从栈A 弹出元素插入到栈B，
     * 再从栈B 弹出元素。如果栈A 为空，直接返回 -1。
     * </p>
     *
     * <p>
     * 时间复杂度：O(1)
     * 空间复杂度：O(N)
     * </p>
     */

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.deleteHead();
    }

    private static class CQueue {
        private final Deque<Integer> mStack1;
        private final Deque<Integer> mStack2;

        public CQueue() {
            mStack1 = new ArrayDeque<>();
            mStack2 = new ArrayDeque<>();
        }

        public void appendTail(int value) {
            mStack1.addLast(value);
        }

        public int deleteHead() {
            if (!mStack2.isEmpty()) {
                return mStack2.pop();
            }
            if (mStack1.isEmpty()) {
                return -1;
            }
            while (!mStack1.isEmpty()) {
                mStack2.addLast(mStack1.pop());
            }
            return mStack2.pop();
        }
    }
}
