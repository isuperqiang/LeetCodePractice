package com.richie.leetcode.easy;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Richie on 2019.07.28
 */
public class Easy_1114 {
    /**
     * 按序打印
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/print-in-order/
     * </p>
     *
     * <p>
     * 描述：
     * 三个不同的线程将会共用一个 Foo 实例，它们会被异步启动。
     * 线程 A 将会调用 one() 方法
     * 线程 B 将会调用 two() 方法
     * 线程 C 将会调用 three() 方法
     * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
     * </p>
     *
     * <p>
     * 解答：排序的思路就是 线程 C 等待线程 B 执行完毕，线程 B 等待线程 A 执行完毕，通过线程阻塞的方式实现，JUC 提供了许多的多线程工具类。
     * - 解法一：CountDownLatch
     * - 解法二：Object 内置锁
     * - 解法三：Lock 和 Condition
     * - 解法四：Semaphore
     * </p>
     */

    public static void main(String[] args) {
        Runnable r1 = () -> {
            System.out.print("first");
        };
        Runnable r2 = () -> {
            System.out.print("second");
        };
        Runnable r3 = () -> {
            System.out.print("third");
        };
        Foo3 foo = new Foo3();
        new Thread(() -> {
            try {
                foo.second(r2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo.third(r3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo.first(r1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    /**
     * 通过 Semaphore
     */
    private static class Foo4 {
        private Semaphore semaphoreSecond = new Semaphore(0);
        private Semaphore semaphoreThird = new Semaphore(0);

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            semaphoreSecond.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            // printSecond.run() outputs "second". Do not change or remove this line.
            semaphoreSecond.acquire();
            printSecond.run();
            semaphoreThird.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            // printThird.run() outputs "third". Do not change or remove this line.
            semaphoreThird.acquire();
            printThird.run();
        }
    }

    /**
     * 通过 Lock 和 Condition
     */
    private static class Foo3 {
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();
        private int state = 1;

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            lock.lock();
            try {
                printFirst.run();
                state = 2;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            // printSecond.run() outputs "second". Do not change or remove this line.
            lock.lock();
            try {
                while (state != 2) {
                    condition.await();
                }
                printSecond.run();
                state = 3;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            // printThird.run() outputs "third". Do not change or remove this line.
            lock.lock();
            try {
                while (state != 3) {
                    condition.await();
                }
                printThird.run();
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * 通过对象内置锁
     */
    private static class Foo2 {
        private final Object lock = new Object();
        private int state = 1;

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            synchronized (lock) {
                printFirst.run();
                state = 2;
                lock.notifyAll();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            // printSecond.run() outputs "second". Do not change or remove this line.
            synchronized (lock) {
                while (state != 2) {
                    lock.wait();
                }
                printSecond.run();
                state = 3;
                lock.notifyAll();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            // printThird.run() outputs "third". Do not change or remove this line.
            synchronized (lock) {
                while (state != 3) {
                    lock.wait();
                }
                printThird.run();
            }
        }
    }

    /**
     * 通过 CountDownLatch
     */
    private static class Foo1 {
        private CountDownLatch countDownLatchSecond = new CountDownLatch(1);
        private CountDownLatch countDownLatchThird = new CountDownLatch(1);

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            countDownLatchSecond.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            // printSecond.run() outputs "second". Do not change or remove this line.
            countDownLatchSecond.await();
            printSecond.run();
            countDownLatchThird.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            // printThird.run() outputs "third". Do not change or remove this line.
            countDownLatchThird.await();
            printThird.run();
        }
    }

}
