package com.richie.leetcode.easy;

/**
 * @author Richie on 2020.05.14
 */
public class Easy_121 {
    /**
     * 买卖股票的最佳时机
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
     * 注意：你不能在买入股票前卖出股票。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     * </p>
     *
     * <p>
     * 解答：
     * 遍历一遍数组，计算每次到当天为止的最小股票价格和最大利润。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = new Easy_121().maxProfit(prices);
        System.out.println(maxProfit); // 6 - 1 = 5
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int maxProfit = 0;
        int minProfit = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < minProfit) {
                minProfit = price;
            } else {
                int diff = price - minProfit;
                if (diff > maxProfit) {
                    maxProfit = diff;
                }
            }
        }
        return maxProfit;
    }
}
