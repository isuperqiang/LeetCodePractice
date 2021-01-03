package com.richie.leetcode.offer;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Richie on 2021.01.03
 */
public class Offer_40 {
    /**
     * 最小的 k 个数
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
     * </p>
     *
     * <p>
     * 描述：
     * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这 8 个数字，则最小的 4 个数字是1、2、3、4。
     * </p>
     *
     * <p>
     * 示例：
     * 输入：arr = [3,2,1], k = 2
     * 输出：[1,2] 或者 [2,1]
     * </p>
     *
     * <p>
     * 解答：
     * - 快速选择
     * - 大顶堆
     * 和题目 215 类似
     * </p>
     *
     * <p>
     * - 快速选择：
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * - 大顶堆：
     * 时间复杂度：O(N*logK)
     * 空间复杂度：O(logK)
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        int[] ans = new Offer_40().getLeastNumbers(nums, 2);
        System.out.println(Arrays.toString(ans));
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || k <= 0) {
            return new int[0];
        }
        quickSelect(arr, 0, arr.length - 1, k);
        int[] ans = new int[k];
        System.arraycopy(arr, 0, ans, 0, k);
        return ans;
    }

    private void quickSelect(int[] nums, int left, int right, int k) {
        if (left >= right) {
            return;
        }
        int index = partition(nums, left, right);
        if (k < index) {
            quickSelect(nums, left, index - 1, k);
        } else if (k > index) {
            quickSelect(nums, index + 1, right, k);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left;
        int r = right;
        while (l < r) {
            while (l < r && nums[r] >= pivot) {
                r--;
            }
            while (l < r && nums[l] <= pivot) {
                l++;
            }
            swap(nums, l, r);
        }
        swap(nums, left, r);
        return r;
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int[] getLeastNumbers2(int[] arr, int k) {
        if (arr == null || k <= 0) {
            return new int[0];
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (i1, i2) -> Integer.compare(i2, i1));
        for (int i : arr) {
            if (maxHeap.isEmpty() || maxHeap.size() < k || i < maxHeap.peek()) {
                maxHeap.offer(i);
            }
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[] ans = new int[k];
        for (int i = 0, size = maxHeap.size(); i < size; i++) {
            ans[i] = maxHeap.poll();
        }
        return ans;
    }
}
