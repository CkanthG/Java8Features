package classes.leetcode;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int max = 0;
        int min = prices[0];
        for (int p : prices) {
            if (p < min) {
                min = p;
            } else if (p - min > max) {
                max = p - min;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        new BestTimeToBuyAndSellStock().maxProfit(new int[]{7,1,5,3,6,4});
    }
}
