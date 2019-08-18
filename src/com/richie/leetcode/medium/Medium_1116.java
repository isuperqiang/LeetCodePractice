package com.richie.leetcode.medium;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @author Richie on 2019.08.18
 */
public class Medium_1116 {
    /**
     * 打印零与奇偶数
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/print-zero-even-odd/
     * </p>
     *
     * <p>
     * 描述：
     * 有这样一个类 ZeroEvenOdd，相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程：
     * - 线程 A 将调用 zero()，它只输出 0 。
     * - 线程 B 将调用 even()，它只输出偶数。
     * - 线程 C 将调用 odd()，它只输出奇数。
     * 每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n。
     * </p>
     *
     * <p>
     * 示例：
     * 输入：n = 2
     * 输出："0102"
     * 说明：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。
     * </p>
     *
     * <p>
     * 解答：线程等待问题，可以使用锁或者信号量解决。
     * - 解法一：Lock 和 Condition
     * - 解法二：Semaphore
     * </p>
     */
    public static void main(String[] args) {
        final IntConsumer printNumber = value -> System.out.print(value);
        ZeroEvenOdd2 zeroEvenOdd = new ZeroEvenOdd2(9);
        new Thread(() -> {
            try {
                zeroEvenOdd.even(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    /**
     * 通过 Semaphore
     */
    private static class ZeroEvenOdd2 {
        private final Semaphore zeroSemaphore = new Semaphore(1);
        private final Semaphore evenSemaphore = new Semaphore(0);
        private final Semaphore oddSemaphore = new Semaphore(0);
        private int n;

        public ZeroEvenOdd2(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                zeroSemaphore.acquire();
                printNumber.accept(0);
                if ((i & 1) == 0) {
                    evenSemaphore.release();
                } else {
                    oddSemaphore.release();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i += 2) {
                evenSemaphore.acquire();
                printNumber.accept(i);
                zeroSemaphore.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i += 2) {
                oddSemaphore.acquire();
                printNumber.accept(i);
                zeroSemaphore.release();
            }
        }
    }

    /**
     * 通过 Lock 和 Condition
     */
    private static class ZeroEvenOdd1 {
        private final Lock lock = new ReentrantLock();
        private final Condition evenCondition = lock.newCondition();
        private final Condition oddCondition = lock.newCondition();
        private final Condition zeroCondition = lock.newCondition();
        private int n;
        private int current = 1;
        // 0 refers zero, 1 refers odd, 2 refers even
        private int state = 0;

        public ZeroEvenOdd1(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            lock.lock();
            try {
                while (current <= n) {
                    if (state != 0) {
                        zeroCondition.await();
                    }
                    printNumber.accept(0);
                    if ((current & 1) == 0) {
                        state = 2;
                        evenCondition.signal();
                    } else {
                        state = 1;
                        oddCondition.signal();
                    }
                    zeroCondition.await();
                }
                oddCondition.signal();
                evenCondition.signal();
            } finally {
                lock.unlock();
            }
        }

        // 偶数
        public void even(IntConsumer printNumber) throws InterruptedException {
            lock.lock();
            try {
                while (current <= n) {
                    if (state != 2) {
                        evenCondition.await();
                    } else {
                        printNumber.accept(current++);
                        state = 0;
                        zeroCondition.signal();
                    }
                }
            } finally {
                lock.unlock();
            }
        }

        // 奇数
        public void odd(IntConsumer printNumber) throws InterruptedException {
            lock.lock();
            try {
                while (current <= n) {
                    if (state != 1) {
                        oddCondition.await();
                    } else {
                        printNumber.accept(current++);
                        state = 0;
                        zeroCondition.signal();
                    }
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
