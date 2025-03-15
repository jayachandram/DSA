class Solution {
    public int coinChange(int[] coins, int sum) {
       int n = coins.length;
        int dp[] = new int[sum + 1];
        

        for (int i = 0; i <= sum; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        dp[0] = 0; 


        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= sum; j++) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], 1 + dp[j - coins[i]]);
                }
            }
        }

        return dp[sum] == Integer.MAX_VALUE ? -1 : dp[sum];
    }
}