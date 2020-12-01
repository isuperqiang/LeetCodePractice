package com.richie.leetcode.easy;

/**
 * @author Richie on 2020.03.18
 */
public class Easy_836 {
    /**
     * 矩形重叠
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/rectangle-overlap/
     * </p>
     *
     * <p>
     * 描述：
     * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
     * 如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
     * 给出两个矩形，判断它们是否重叠并返回结果。
     * </p>
     *
     * <p>
     * 示例：
     * 输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
     * 输出：true
     * </p>
     *
     * <p>
     * 解答：
     * 逆向思维，考虑 rect1 和 rect2 不会重合的情况。假设固定 rect2，那就是 rect1 出现在 rect2 的上下左右四个方位。
     * </p>
     */

    public static void main(String[] args) {
        int[] rect1 = {0, 0, 1, 1};
        int[] rect2 = {1, 0, 2, 1};
        boolean rectangleOverlap = isRectangleOverlap(rect1, rect2);
        System.out.println("result: " + rectangleOverlap);
    }

    private static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec1 == null || rec1.length != 4 || rec2 == null || rec2.length != 4) {
            return false;
        }
        boolean isOverlap = !(rec1[0] >= rec2[2] || rec1[2] <= rec2[0] || rec1[1] >= rec2[3] || rec1[3] <= rec2[1]);
        return isOverlap;
    }
}
