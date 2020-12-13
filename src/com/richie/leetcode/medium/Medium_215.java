package com.richie.leetcode.medium;

import java.util.PriorityQueue;

/**
 * @author Richie on 2020.05.13
 */
public class Medium_215 {
    /**
     * 数组中的第 K 个最大元素
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
     * </p>
     *
     * <p>
     * 描述：在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     * </p>
     *
     * <p>
     * 解答：
     * - 小顶堆：创建一个小顶堆，将所有数组中的元素加入堆中，并保持堆的大小 <= k。这样，堆中就保留了前 k 个最大的元素，堆顶元素就是答案。
     * - 快速选择：要找的位置就是排序后倒数第 K 个值，其索引是 nums.length - K。
     * </p>
     *
     * <p>
     * 快速选择：
     * - 时间复杂度：O(N)
     * - 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int kthLargest = new Medium_215().findKthLargest(nums, 2);
        System.out.println(kthLargest);
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        int target = length - k;
        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
        int r = right;
        while (true) {
            while (l <= r && nums[l] < pivot) {
                l++;
            }
            while (l <= r && nums[r] > pivot) {
                r--;
            }
            if (l > r) {
                break;
            }
            swap(nums, l, r);
            l++;
            r--;
        }
        swap(nums, left, r);
        return r;
    }

    private void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }

    public int findKthLargest2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
