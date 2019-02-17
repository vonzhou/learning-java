package oj.leetcode;

/**
 * 121. Best Time to Buy and Sell Stock
 * Created by vonzhou on 2019/2/17.
 */
public class BestTimeBuyAndSellStock {

    /**
     * 动态规划
     * 遍历过程记录最低价格, 然后计算当天卖出的收益
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;

        int low = prices[0];
        int max = 0;//最大收益(买卖股票的差价)
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - low);
            low = Math.min(low, prices[i]);
        }
        return max;
    }
}
