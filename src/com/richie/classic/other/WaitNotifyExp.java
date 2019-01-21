package com.richie.classic.other;

/**
 * @author richie on 2018.06.22
 * 交替打印奇数和偶数
 */
public class WaitNotifyExp {

    private int index = 1;
    private boolean flag;

    public static void main(String[] args) {

        WaitNotifyExp waitNotifyExp = new WaitNotifyExp();
        new Thread(new OuPrinter(waitNotifyExp)).start();
        new Thread(new JiPrinter(waitNotifyExp)).start();

    }

    private static class OuPrinter implements Runnable {
        private WaitNotifyExp exp;

        public OuPrinter(WaitNotifyExp exp) {
            this.exp = exp;
        }

        @Override
        public void run() {
            synchronized (WaitNotifyExp.class) {
                while (exp.index <= 10) {
                    if (exp.flag) {
                        System.out.println(Thread.currentThread().getName() + " 打印偶数：" + exp.index++);
                        exp.flag = false;
                        WaitNotifyExp.class.notify();
                    } else {
                        try {
                            WaitNotifyExp.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private static class JiPrinter implements Runnable {
        private WaitNotifyExp exp;

        public JiPrinter(WaitNotifyExp exp) {
            this.exp = exp;
        }

        @Override
        public void run() {
            synchronized (WaitNotifyExp.class) {
                while (exp.index <= 10) {
                    if (!exp.flag) {
                        System.out.println(Thread.currentThread().getName() + " 打印奇数：" + exp.index++);
                        exp.flag = true;
                        WaitNotifyExp.class.notify();
                    } else {
                        try {
                            WaitNotifyExp.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
