package com.richie.classic.other;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author richie on 2018.07.10
 */
public class ThreadT {

    public static void main(String[] args) {

        //Thread threadA = new Thread(new ARun(), "A");
        //Thread threadB = new Thread(new ARun(), "B");
        //Thread threadC = new Thread(new ARun(), "C");
        //try {
        //threadA.start();
        //threadA.join();
        //threadB.start();
        //threadB.join();
        //threadC.start();
        //    threadC.join();
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}

        Lock lock = new ReentrantLock();
        lock.lock();
        try {

        } finally {
            lock.unlock();
        }

        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");
        Node h = new Node("H");
        List<Node> aChild = new ArrayList<>();
        aChild.add(b);
        aChild.add(c);
        aChild.add(d);
        a.child = aChild;
        List<Node> bChild = new ArrayList<>();
        bChild.add(e);
        bChild.add(f);
        b.child = bChild;
        List<Node> cChild = new ArrayList<>();
        cChild.add(g);
        c.child = cChild;
        List<Node> fChild = new ArrayList<>();
        fChild.add(h);
        f.child = fChild;

        travelse(a);
        // A, B, E, F, H, C, G, D,
    }

    // 递归遍历
    private static void travelse(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.var + ", ");
        if (root.child == null) {
            return;
        }

        for (Node node : root.child) {
            travelse(node);
        }
    }

    static class Node {
        String var;
        List<Node> child;

        Node(String var) {
            this.var = var;
        }
    }

    private static class ARun implements Runnable {

        @Override
        public void run() {
            System.out.println("thread: " + Thread.currentThread().getName() + " start");
        }
    }

}
