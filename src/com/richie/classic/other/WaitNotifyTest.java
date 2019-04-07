package com.richie.classic.other;

/**
 * @author richie on 2019.04.06
 */
public class WaitNotifyTest {
    private final Object lock = new Object();
    private final Object numberLock = new Object();

    /*
线程 A 拿到锁了，开始工作
线程 A 释放了锁，进入等待状态
线程 B 拿到了锁，开始工作
-----------------------
线程 B 发信号了，完成工作
线程 B 释放了锁
线程 A 收到信号，继续工作
线程 A 释放了锁
* */
    private boolean finished;
    private int number = 10;

    public void start() {
        new Thread(new TaskA()).start();
        new Thread(new TaskB()).start();
    }

    public void printNumber() {
        new Thread(new EvenTask()).start();
        new Thread(new OddTask()).start();
    }

    private class TaskA implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("线程 A 拿到锁了，开始工作");
                while (!finished) {
                    try {
                        System.out.println("线程 A 释放了锁，进入等待状态");
                        lock.wait();
                        System.out.println("线程 A 收到信号，继续工作");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("线程 A 释放了锁");
        }
    }

    private class TaskB implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("线程 B 拿到了锁，开始工作");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("-----------------------");
                System.out.println("线程 B 发信号了，完成工作");
                finished = true;
                lock.notify();
            }
            System.out.println("线程 B 释放了锁");
        }
    }

    // 偶数
    private class EvenTask implements Runnable {

        @Override
        public void run() {
            synchronized (numberLock) {
                while (number >= 0 && (number & 1) == 0) {
                    System.out.println("偶数: " + (number--));
                    numberLock.notify();
                    try {
                        numberLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    // 奇数
    private class OddTask implements Runnable {

        @Override
        public void run() {
            synchronized (numberLock) {
                while (number >= 0 && (number & 1) == 1) {
                    System.out.println("奇数: " + (number--));
                    numberLock.notify();
                    try {
                        numberLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
