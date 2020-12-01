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
     * - 小顶堆：创建一个小顶堆，将所有数组中的元素加入堆中，并保持堆的大小 <= k。这样，堆中就保留了前 k 个最大的元素，堆顶的元素就是正确答案。
     * - 快速选择：todo
     * </p>
     *
     * <p>
     * - 时间复杂度：O(N*logk)
     * - 空间复杂度：O(k)
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int kthLargest = new Medium_215().findKthLargest(nums, 2);
        System.out.println(kthLargest); // 5
    }

    public int findKthLargest(int[] nums, int k) {
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
