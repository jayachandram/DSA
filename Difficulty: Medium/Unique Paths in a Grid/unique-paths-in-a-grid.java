class Solution {
    public int uniquePaths(int[][] grid) {
        // code here
        int n = grid.length, m = grid[0].length;
        if(grid[n - 1][m - 1] == 1 || grid[0][0] == 1) return 0;
        int[][] dp = new int[n + 1][m + 1];
        for(int[] i : dp) Arrays.fill(i, - 1);
        return f(grid, 0, 0, dp);
    }
    private int f(int[][] grid, int i, int j, int[][] dp)
    {
        if(i < 0 || i > grid.length || j < 0 || j > grid[0].length) return 0;
        if(i < grid.length && j < grid[0].length && grid[i][j] == 1) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(i == grid.length -1 && j == grid[0].length - 1) return 1;
        
        return dp[i][j] = f(grid, i + 1, j, dp) + f(grid, i, j + 1, dp);
    }
};