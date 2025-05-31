class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // code here
        
        int n = matrix.length;
        int ans = -1;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];
        
        while(left <= right)
        {
           int mid = (left + right) / 2;
           int row = 0, col = n - 1;
           int count = 0;
           while(row < n && col >= 0)
           {
               if(matrix[row][col] <= mid)
               {
                   count += col + 1;
                   row++;
               }
               else
                    col--;
           }
           if(count < k)
           {
               left = mid + 1;
           }
           else
           {
                right = mid -1;
           }
        }
        return left;
    }
}