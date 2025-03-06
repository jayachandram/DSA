class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] ans = new int[2];

        for(int row = 0; row < n; row++)
        {
            for(int col = 0; col < n; col++)
            {
                int ele = Math.abs(grid[row][col]);
                int r = (ele - 1) / n;
                int c = (ele - 1) % n;
                if(grid[r][c] < 0)
                    ans[0] = Math.abs(ele);
                else
                    grid[r][c] *= -1;
            }
        }

        for(int row = 0; row < n; row++)
        {
            for(int col = 0; col < n; col++)
            {
                if(grid[row][col] > 0){
                    ans[1] = row * n + col + 1;
                    break;
                }
            }
        }
        return ans;
    }
}