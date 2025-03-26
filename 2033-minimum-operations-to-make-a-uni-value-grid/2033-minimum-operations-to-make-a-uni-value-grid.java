class Solution {
    public int minOperations(int[][] grid, int x) {

        int m = grid.length, n = grid[0].length;

        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(grid[i][j] % x != grid[0][0] % x)
                    return -1;

        
        int[] array = new int[m * n];

        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
               array[i * n + j] = grid[i][j];

        Arrays.sort(array);

        int median = (m * n) / 2;
        median = array[median];
        int steps = 0;

        for(int i : array)
            steps += Math.abs((i - median)) / x;

        return steps;
    }
}