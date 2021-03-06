package com.richie.leetcode.medium;

import java.util.PriorityQueue;
import java.util.Random;

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
     * - 快速选择：要找的位置就是排序后倒数第 K 个值，其索引是 nums.length - K。切分 partition 总能排定一个元素，还可以知道它的最终位置，
     * 每经过一次切分，就能够缩小搜索的范围。使用随机数选择 pivot，避免极端测试用例耗时。
     * - 小顶堆：创建一个小顶堆，将所有数组中的元素加入堆中，并保持堆的大小 <= k。这样，堆中就保留了前 k 个最大的元素，堆顶元素就是答案。
     * </p>
     *
     * <p>
     * - 快速选择：
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * - 小顶堆：
     * 时间复杂度：O(N)
     * 空间复杂度：O(K)
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int ans = new Medium_215().findKthLargest(nums, 2);
        System.out.println(ans);
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        int target = length - k;
        Random random = new Random(System.currentTimeMillis());
        while (true) {
            if (left < right) {
                int randomIndex = left + 1 + random.nextInt(right - left);
                int temp = nums[left];
                nums[left] = nums[randomIndex];
                nums[randomIndex] = temp;
            }
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
