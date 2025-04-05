//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        while (tc-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.countIslands(grid);
            System.out.println(ans);
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    public int countIslands(char[][] grid) {
        // Code here
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        boolean[][] visited = new boolean[m][n];
                

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 'L' && !visited[i][j])
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
            
            for(int nextRow = -1; nextRow <= 1; nextRow++)
            {
                for(int nextCol = -1; nextCol <= 1; nextCol++)
                {
                    int neighbourRow = currentRow + nextRow;
                    int neighbourCol = currentCol + nextCol;
                    
                    if(neighbourRow >= 0 && neighbourRow < m && neighbourCol >= 0 && neighbourCol < n &&
                       grid[neighbourRow][neighbourCol] == 'L' && !visited[neighbourRow][neighbourCol] )
                    {
                        visited[neighbourRow][neighbourCol] = true;
                        queue.add(new ArrayList<>(Arrays.asList(neighbourRow, neighbourCol)));
                    }
                }
            }
        }
        
    }
}