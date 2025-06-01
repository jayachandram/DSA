class Solution {
    int countPairs(int[][] mat1, int[][] mat2, int x) {
        // code here
        
        int n = mat1.length;
        int i = 0, j = n * n - 1;
        int ans = 0;
        
        while(i < n * n && j >= 0)
        {
            int row1 = i / n, row2 = j / n;
            int col1 = i % n, col2 = j % n;
            
            int val = mat1[row1][col1] + mat2[row2][col2];
            
            if(val == x) 
            {
                ans++;
                i++;
                j--;
            }
            else if(val < x) i++;
            else j--;
        }
        return ans++;
    }
}