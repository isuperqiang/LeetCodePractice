package com.richie.classic.sort;

/**
 * @author richie on 2018.07.15
 */
public class SortUtils {
    private SortUtils() {
    }

    public static void swap(int[] a, int p, int q) {
        int temp = a[p];
        a[p] = a[q];
        a[q] = temp;
    }
}
