class Solution {
    public int numRollsToTarget(int n, int m, int x) {
        int[][] dp = new int[n + 1][x + 1];
        
        for(int[] row : dp)
            Arrays.fill(row, -1);
            
        return f(m, n, x, 0, dp);
    }
    private static int f(int m, int n, int x, long ans, int[][] dp)
    {
        if(n == 0 && x == 0)
            return 1;
            
        if(n == 0 || x <= 0)
            return 0;
            
        if(dp[n][x] != -1)
            return dp[n][x];
            
        ans = 0;
        
        for(int i = 1; i <= m; i++)
            ans = (ans + f(m, n - 1, x - i, ans, dp) ) % 1000000007;
        
        return dp[n][x] = (int)ans;
    }
};