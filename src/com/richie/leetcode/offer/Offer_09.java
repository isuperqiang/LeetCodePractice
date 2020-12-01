package com.richie.leetcode.offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 *
 * @author Richie on 2020.12.01
 */
public class Offer_09 {
    private final Deque<Integer> mStack1 = new ArrayDeque<>();
    private final Deque<Integer> mStack2 = new ArrayDeque<>();

    public Offer_09() {

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
            Integer pop = mStack1.pop();
            mStack2.addLast(pop);
        }
        return mStack2.pop();
    }
}
