package com.richie.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Richie on 2020.03.26
 */
public class Easy_225 {
    /**
     * 用队列实现栈
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/implement-stack-using-queues/
     * </p>
     *
     * <p>
     * 描述：
     * 使用队列实现栈的下列操作：
     * push(x) -- 元素 x 入栈
     * pop() -- 移除栈顶元素
     * top() -- 获取栈顶元素
     * empty() -- 返回栈是否为空
     * </p>
     *
     * <p>
     * 解答：
     * 使用 ArrayDeque 实现，把队尾当作栈顶。
     * </p>
     */

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
        System.out.println("pop1:" + param_2 + ", pop2:" + param_3 + ", isEmpty:" + param_4);
    }

    private static class MyStack {
        private Deque<Integer> queue;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            queue = new ArrayDeque<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queue.addLast(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return queue.removeLast();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return queue.getLast();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
