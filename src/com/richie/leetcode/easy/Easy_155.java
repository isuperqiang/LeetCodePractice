package com.richie.leetcode.easy;

import java.util.Stack;

/**
 * @author richie on 2019.04.19
 */
public class Easy_155 {
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
     * 解答：
     * - 法一：辅助栈，可以用两个栈，一个栈去保存正常的入栈出栈的值，另一个栈去保存最小值，也就是用栈顶保存当前所有元素的最小值。
     * - 法二：自定义 Stack，可以在 Node 节点中增加一个 min 字段，这样每次加入一个节点时，同时只要确定它的 min 值即可。
     * </p>
     *
     * <p>
     * 辅助栈：
     * - 时间复杂度：O(1)
     * - 空间复杂度：O(N)
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
        int top = minStack.top();
        System.out.println("top:" + top);
        int min2 = minStack.getMin();
        System.out.println("min2 " + min2);
    }

    private final Stack<Integer> stack = new Stack<>();
    private final Stack<Integer> stackHelper = new Stack<>();

    public void push(int x) {
        stack.push(x);
        if (stackHelper.isEmpty() || x <= stackHelper.peek()) {
            stackHelper.push(x);
        }
    }

    public void pop() {
        int pop = stack.pop();
        if (pop == stackHelper.peek()) {
            stackHelper.pop();
        }
    }

    public int top() {
        return stack.pop();
    }

    public int getMin() {
        return stackHelper.peek();
    }

}
