package com.richie.classic.other;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author richie on 2019.03.19
 */
public class CollectionsTest {

    public static void main(String[] args) {
        cow();
    }

    private static void cow() {
        CopyOnWriteArrayList<String> names = new CopyOnWriteArrayList<>();
        names.add("one");
        names.add("two");
        names.add("three");
        for (String name : names) {
            System.out.println(name);
        }
    }

    private static void removeElements() {
        List<String> names = new ArrayList<>();
        names.add("one");
        names.add("two");
        names.add("three");
        // 正确
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            if ("one".equals(name)) {
                iterator.remove();
            }
        }

        // 错误
        //for (String name : names) {
        //    if ("one".equals(name)) {
        //        names.remove(name);
        //    }
        //}
        System.out.println(names);
    }

}
