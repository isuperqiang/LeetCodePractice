package com.richie.classic.other;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author richie on 2018.07.26
 */
public class InterViewQuestion1 {
    private static final String PATH = "/Users/richie/Documents/eBook";

    public static void main(String[] args) {
        File file = new File(PATH);
        traverFile1(file);
        //traverFile2(file);
        //traverFile3(file);
    }

    // 采用递归的方式实现树的深度优先遍历
    private static void traverFile1(File file) {
        System.out.println(file);
        File[] files = file.listFiles();
        if (files != null && file.isDirectory()) {
            for (File f : files) {
                traverFile1(f);
            }
        }
    }

    // 借助队列结构来实现树的广度优先遍历
    private static void traverFile2(File file) {
        LinkedList<File> list = new LinkedList<>();
        list.add(file);
        while (!list.isEmpty()) {
            File f = list.poll();
            System.out.println(f);
            File[] files = f.listFiles();
            if (files != null) {
                list.addAll(Arrays.asList(files));
            }
        }
    }

    // 借助栈结构来实现树的深度优先遍历
    private static void traverFile3(File file) {
        LinkedList<File> list = new LinkedList<>();
        list.add(file);
        while (!list.isEmpty()) {
            File f = list.pop();
            System.out.println(f);
            File[] files = f.listFiles();
            if (files != null) {
                for (File fil : files) {
                    list.push(fil);
                }
            }
        }
    }
}
