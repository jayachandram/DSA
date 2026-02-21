class Solution {
    public int maxProfit(int[] prices) {
        int minimum = prices[0];
        int maxProfit = 0;

        for(int i : prices)
        {
            int cost = i - minimum;
            maxProfit = Math.max(maxProfit, cost);
            minimum = Math.min(minimum, i);
        }

        return maxProfit;
    }
}