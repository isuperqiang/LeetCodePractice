package com.richie.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author richie on 2018.06.12
 */
public class Easy_350 {

    /**
     * 两个数组的交集
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/description/
     * </p>
     *
     * <p>
     * 描述：给定两个数组，写一个方法来计算它们的交集。
     * 跟进:
     * 如果给定的数组已经排好序呢？你将如何优化你的算法？
     * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
     * 如果nums2的元素存储在磁盘上，内存是有限的，你不能一次加载所有的元素到内存中，你该怎么办？
     * </p>
     *
     * <p>
     * 解答：先给两个数组排序，然后用两个索引分别指向两个数组的起始位置，如果两个索引所代表的数字相等，则将数字存入结果中，两个索引均自增1，
     * 如果第一个索引所代表的数字大，则第二个索引自增1，反之亦然。
     * </p>
     */

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] intersect = intersect(nums1, nums2);
        System.out.println(Arrays.toString(intersect));
    }

    private static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i = 0;
        int j = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] ret = new int[list.size()];
        for (int t = 0; t < list.size(); t++) {
            ret[t] = list.get(t);
        }
        return ret;
    }
}
