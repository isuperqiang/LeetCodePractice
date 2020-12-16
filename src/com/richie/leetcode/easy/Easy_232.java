package com.richie.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Richie on 2020.12.16
 */
public class Easy_232 {
    /**
     * 用栈实现队列
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks/
     * </p>
     *
     * <p>
     * 描述：
     * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列的支持的所有操作（push、pop、peek、empty）：
     * 实现 MyQueue 类：
     * void push(int x) 将元素 x 推到队列的末尾
     * int pop() 从队列的开头移除并返回元素
     * int peek() 返回队列开头的元素
     * boolean empty() 如果队列为空，返回 true ；否则，返回 false
     * </p>
     *
     * <p>
     * 示例：
     * 输入：
     * ["MyQueue", "push", "push", "peek", "pop", "empty"]
     * [[], [1], [2], [], [], []]
     * 输出：
     * [null, null, null, 1, 1, false]
     * 解释：
     * MyQueue myQueue = new MyQueue();
     * myQueue.push(1); // queue is: [1]
     * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
     * myQueue.peek(); // return 1
     * myQueue.pop(); // return 1, queue is [2]
     * myQueue.empty(); // return false
     * </p>
     *
     * <p>
     * 解答：
     * 一个栈用于入队，另一个栈用于出队。pop 或 peek 时，如果出队的栈里有元素，直接从 pop 或 peek。否则将入队的栈中的所有元素转移到出队的栈。
     * </p>
     *
     * <p>
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.peek();
        myQueue.pop();
        boolean empty = myQueue.empty();
        System.out.println(empty);
    }

    private static class MyQueue {
        private final Deque<Integer> pushStack;
        private final Deque<Integer> popStack;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            pushStack = new ArrayDeque<>();
            popStack = new ArrayDeque<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            pushStack.addLast(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (!popStack.isEmpty()) {
                return popStack.removeLast();
            }
            while (!pushStack.isEmpty()) {
                popStack.addLast(pushStack.removeLast());
            }
            return popStack.isEmpty() ? -1 : popStack.removeLast();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (!popStack.isEmpty()) {
                return popStack.peekLast();
            }
            while (!pushStack.isEmpty()) {
                popStack.addLast(pushStack.removeLast());
            }
            return popStack.isEmpty() ? -1 : popStack.peekLast();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return popStack.isEmpty() && pushStack.isEmpty();
        }
    }
}
