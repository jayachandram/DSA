class Solution {
    public int numIslands(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        boolean[][] visited = new boolean[m][n];
                

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == '1' && !visited[i][j])
                {
                    count++;
                    bfs(grid, i, j, visited);
                }
            }
        }
        
        return count;
    }
    private void bfs(char[][] grid, int row, int col, boolean[][] visited)
    {        
        int m = grid.length;
        int n = grid[0].length;
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        queue.add(new ArrayList<>(Arrays.asList(row, col)));
        visited[row][col] = true;
        
        while(!queue.isEmpty())
        {
            int currentRow = queue.peek().get(0);
            int currentCol = queue.peek().get(1);
            queue.poll();
            int[] arr1 = new int[]{0, 0, 0, 1};
            int[] arr2 = new int[]{-1, 0, 1, 0};

            for(int i = 0; i < 4; i++)
            {
                int neighbourRow = currentRow + arr1[i];
                int neighbourCol = currentCol + arr2[i];

                if(neighbourRow >= 0 && neighbourRow < m && neighbourCol >= 0 && neighbourCol < n &&
                   grid[neighbourRow][neighbourCol] == '1' && !visited[neighbourRow][neighbourCol] )
                {
                    visited[neighbourRow][neighbourCol] = true;
                    queue.add(new ArrayList<>(Arrays.asList(neighbourRow, neighbourCol)));
                }
            }
        }
        
    }
}