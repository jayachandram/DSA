class Solution {
    public int change(int sum, int[] coins) {
        int n = coins.length;
        int[] dp = new int[sum + 1];

        // Base case: one way to make sum 0 (use no coins)
        dp[0] = 1;

        // Process each coin one by one
        for (int i = 0; i < n; i++) {
            // Traverse from sum to coins[i] to avoid overwriting
            for (int j = coins[i]; j <= sum; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[sum];
    }
}