//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = scanner.nextInt(); // Number of rows
            int m = scanner.nextInt(); // Number of columns
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    public int numIslands(char[][] grid) {
        // Code here
        int r = grid.length, c = grid[0].length, ans = 0;
        //boolean[][] visited = new int[r][c];
        for(int row = 0; row < r; row++)
        {
            for(int col = 0; col < c; col++)
            {
                if(grid[row][col] == '1'){
                    dfs(grid, row, col);
                    ans += 1;
                }
                
            }
        }
        return ans;
    }
    private void dfs(char[][] grid, int row, int col)
    {
        int[] next1 = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] next2 = { -1, 0, 1, -1, 1, -1, 0, 1 };
        
        grid[row][col] = '0';
        
        for(int k = 0; k < 8; k++)
        {
            int newR = row + next1[k];
            int newC = col + next2[k];
            
            if(isSafe(grid, newR, newC))
                dfs(grid, newR, newC);
            
        }
    }
    private boolean isSafe(char[][] grid, int row, int col)
    {
        int r = grid.length, c = grid[0].length;
        
        return (row > -1 && row < r && col > -1 && col < c && grid[row][col] == '1');
    }
}