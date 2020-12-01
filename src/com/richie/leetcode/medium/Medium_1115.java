package com.richie.leetcode.medium;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Richie on 2019.07.28
 */
public class Medium_1115 {
    /**
     * 交替打印 FooBar
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/print-foobar-alternately/
     * </p>
     *
     * <p>
     * 描述：
     * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
     * 请设计修改程序，以确保 "foobar" 被输出 n 次。
     * </p>
     *
     * <p>
     * 解答：线程等待问题，可以使用锁或者信号量解决。
     * - 解法一：Lock 和 Condition
     * - 解法二：Object 内置锁
     * - 解法三：Semaphore
     * </p>
     */

    public static void main(String[] args) {
        Runnable r1 = () -> {
            System.out.print("Foo");
        };
        Runnable r2 = () -> {
            System.out.print("Bar");
        };
        FooBar2 fooBar = new FooBar2(20);
        new Thread(() -> {
            try {
                fooBar.bar(r2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fooBar.foo(r1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    /**
     * 通过 Semaphore
     */
    private static class FooBar3 {
        private int n;
        private Semaphore semaphoreFoo = new Semaphore(1);
        private Semaphore semaphoreBar = new Semaphore(0);

        public FooBar3(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                semaphoreFoo.acquire();
                printFoo.run();
                semaphoreBar.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                semaphoreBar.acquire();
                printBar.run();
                semaphoreFoo.release();
            }
        }
    }

    /**
     * 通过 Object 内置锁
     */
    private static class FooBar2 {
        private final Object lock = new Object();
        private int n;
        private boolean flag;

        public FooBar2(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                synchronized (lock) {
                    while (flag) {
                        lock.wait();
                    }
                    flag = true;
                    printFoo.run();
                    lock.notify();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                synchronized (lock) {
                    while (!flag) {
                        lock.wait();
                    }
                    flag = false;
                    printBar.run();
                    lock.notify();
                }
            }
        }
    }

    /**
     * 通过 Lock 和 Condition
     */
    private static class FooBar1 {
        private int n;
        private Lock lock = new ReentrantLock();
        private Condition fooCondition = lock.newCondition();
        private Condition barCondition = lock.newCondition();
        private int state = 0;

        public FooBar1(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                lock.lock();
                try {
                    if (state != 0) {
                        fooCondition.await();
                    }
                    state = 1;
                    printFoo.run();
                    barCondition.signal();
                } finally {
                    lock.unlock();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                lock.lock();
                try {
                    if (state != 1) {
                        barCondition.await();
                    }
                    state = 0;
                    printBar.run();
                    fooCondition.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
