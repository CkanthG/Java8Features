package classes.leetcode;

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        new BestTimeToBuyAndSellStockII().maxProfit(new int[]{7,1,5,3,6,4});
    }
}
