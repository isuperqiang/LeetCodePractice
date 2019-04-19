package com.richie.leetcode.easy;

import java.util.Stack;

/**
 * @author richie on 2019.04.19
 */
public class Easy_155 {
    private Stack<Integer> stack = new Stack<>();

    /**
     * initialize your data structure here.
     */
    public Easy_155() {

    }

    /**
     * 最小栈
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/min-stack/
     * </p>
     *
     * <p>
     * 描述：设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
     * push(x) -- 将元素 x 推入栈中。
     * pop() -- 删除栈顶的元素。
     * top() -- 获取栈顶元素。
     * getMin() -- 检索栈中的最小元素。
     * </p>
     *
     * <p>
     * 示例：
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.getMin();   --> 返回 -2.
     * </p>
     *
     * <p>
     * 解答：每次入栈 2 个元素，一个是要入栈的元素本身，一个是当前栈内元素的最小值。
     * 如：入栈序列为 2-3-1，则入栈后元素序列为：2-2-3-2-1-1。用空间代价来换取时间代价
     * </p>
     */

    public static void main(String[] args) {
        Easy_155 minStack = new Easy_155();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min1 = minStack.getMin();
        System.out.println("min1 " + min1);
        minStack.pop();
        minStack.top();
        int min2 = minStack.getMin();
        System.out.println("min2 " + min2);
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            stack.push(x);
        } else {
            Integer currMin = stack.peek();
            stack.push(x);
            stack.push(x < currMin ? x : currMin);
        }
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
        return stack.get(stack.size() - 2);
    }

    public int getMin() {
        return stack.peek();
    }

}
