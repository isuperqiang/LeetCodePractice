package com.richie.classic.other;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author richie on 2019.04.06
 */
public class ConditionDemo {
    private Lock reentrantLock = new ReentrantLock();
    private Condition condition = reentrantLock.newCondition();
    /* 交替打印奇偶数 */
    private int number = 10;
    private Condition evenCondition = reentrantLock.newCondition();
    private Condition oddCondition = reentrantLock.newCondition();

    /*
    线程 C 拿到了锁，开始工作
线程 C 释放了锁，进入等待状态
线程 D 拿到了锁，开始工作
-----------------------
线程 D 发信号了，完成工作
线程 D 释放了锁
线程 C 收到信号，继续工作
线程 C 释放了锁
    * */
    public void start() {
        new Thread(new TaskC()).start();
        new Thread(new TaskD()).start();
        condition.awaitUninterruptibly();
    }

    public void printNumber() {
        new Thread(new EvenTask()).start();
        new Thread(new OddTask()).start();
    }

    private class TaskC implements Runnable {

        @Override
        public void run() {
            reentrantLock.lock();
            System.out.println("线程 C 拿到了锁，开始工作");
            try {
                System.out.println("线程 C 释放了锁，进入等待状态");
                condition.await();
                System.out.println("线程 C 收到信号，继续工作");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("线程 C 释放了锁");
                reentrantLock.unlock();
            }
        }
    }

    private class TaskD implements Runnable {

        @Override
        public void run() {
            reentrantLock.lock();
            System.out.println("线程 D 拿到了锁，开始工作");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("-----------------------");
            try {
                System.out.println("线程 D 发信号了，完成工作");
                condition.signal();
            } finally {
                System.out.println("线程 D 释放了锁");
                reentrantLock.unlock();
            }
        }
    }

    // 偶数
    private class EvenTask implements Runnable {

        @Override
        public void run() {
            reentrantLock.lock();
            try {
                while (number >= 0 && (number & 1) == 0) {
                    System.out.println("偶数: " + (number--));
                    oddCondition.signal();
                    evenCondition.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    // 奇数
    private class OddTask implements Runnable {

        @Override
        public void run() {
            reentrantLock.lock();
            try {
                while (number >= 0 && (number & 1) == 1) {
                    System.out.println("奇数: " + (number--));
                    evenCondition.signal();
                    oddCondition.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    /*
    * 偶数: 10
奇数: 9
偶数: 8
奇数: 7
偶数: 6
奇数: 5
偶数: 4
奇数: 3
偶数: 2
奇数: 1
偶数: 0
    * */

}
