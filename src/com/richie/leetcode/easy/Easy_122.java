package com.richie.leetcode.easy;

/**
 * @author Richie on 2020.05.14
 */
public class Easy_122 {
    /**
     * 买卖股票的最佳时机 II
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     * </p>
     *
     * <p>
     * 解答：
     * 贪心算法：遍历整个股票交易日价格列表，所有上涨交易日都买卖（赚到所有利润），所有下降交易日都不买卖（永不亏钱）。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit); // 5-1, 6-3 -> 7
    }

    private static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                maxProfit += diff;
            }
        }
        return maxProfit;
    }
}
