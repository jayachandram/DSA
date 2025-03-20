class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        if(obstacleGrid[m-1][n-1] == 1)
            return 0;

        return f(obstacleGrid, 0, 0, m - 1, n - 1, dp);
    }
    private int f(int[][] obstacleGrid, int i, int j, int m, int n, int[][] dp)
    {

        if(i == m && j == n)
            return 1;

        if(i > m || j  > n)
            return 0;

        if(dp[i][j] != 0)
            return dp[i][j];

        if(obstacleGrid[i][j] == 1)
            return 0;

        return dp[i][j] = f(obstacleGrid, i+1,j, m, n, dp) + f(obstacleGrid, i, j+1, m, n, dp);

    }
}