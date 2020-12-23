package com.richie.leetcode.medium;

/**
 * @author Richie on 2020.09.11
 */
public class Medium_11 {
    /**
     * 盛最多水的容器
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/container-with-most-water/
     * </p>
     *
     * <p>
     * 描述：
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     * </p>
     *
     * <p>
     * 示例：
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * </p>
     *
     * <p>
     * 解答：双指针
     * 面积 s[i,j]=max(h[i], h[j]]) * (j-i)，i j 分别是数组的左右指针。容器容纳的水量是由短板决定的，所以，
     * - h[i]>h[j] 时，左移 j，容量可能会变大，右移 i，容量不会变大。
     * - h[i]<h[j] 时，左移 j，容量不会变大，右移 i，容量可能会变大。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * </p>
     */
    public static void main(String[] args) {
        int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int ans = new Medium_11().maxArea(input);
        System.out.println(ans);
    }

    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int w = right - left;
            int h = Math.min(height[left], height[right]);
            max = Math.max(w * h, max);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }
}
