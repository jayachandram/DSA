class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return f(m-1, n-1, dp);
    }
    private int f(int m, int n, int[][]dp)
    {
        if(m == 0 && n == 0)
            return 1;

        if(m < 0 || n  < 0)
            return 0;

        if(dp[m][n] != 0)
            return dp[m][n];

        // int left = f(m-1, n);
        // int up = f(m, n-1);


        return dp[m][n] = (f(m-1,n, dp) + f(m, n-1, dp));
    }
}