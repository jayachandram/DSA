class Solution {
    public int maxProfit(int[] prices) {
        // Code here
        int  max = -1, profit = 0;
        
        for(int i = prices.length - 1; i >= 0; i--)
        {
            if(prices[i] > max)
            {
                max = prices[i];
            }
            profit = Math.max(profit, max - prices[i]);
        }
        
        return profit;
        
        
    }
}