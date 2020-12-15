package github.zayn.leetcodexx.array.leetcode121;

public class MaxProfit {
    /**
     * leetcode 121 买卖股票最大时机(只可购买一次)
     * 一次遍历
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }


    public int maxProfitV2(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        int i = 0;
        for (i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            }
        }
        for (int j = i; j < prices.length; j++) {
            if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

    public static int maxProfitV3(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int profit[] = new int[prices.length];
        int dp[] = new int[prices.length];
        dp[0] = Math.max(0, profit[0]);

        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1] + profit[i], 0);
            maxProfit = Math.max(dp[i], maxProfit);
        }
        return maxProfit;
    }

    /**
     * leetcode 122 买卖股票最大时机(可多次购买)
     * 传统dp 思想是
     *
     * @param prices
     * @return
     */
    public static int maxProfitV4(int[] prices) {
        int length = prices.length + 1;
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        for (int n = 1; n < length; n++) {
            dp[n][0] = Math.max(dp[n - 1][1] + prices[n - 1], dp[n - 1][0]);
            dp[n][1] = Math.max(dp[n - 1][0] - prices[n - 1], dp[n - 1][1]);
        }
        return dp[length-1][0];
    }
    
}
