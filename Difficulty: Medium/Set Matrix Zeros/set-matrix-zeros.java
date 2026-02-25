class Solution {
    public void setMatrixZeroes(int[][] matrix) {
        // code here
        int flag1 = 0, flag2 = 0;

        for(int i = 0; i < matrix[0].length; i++)
        {
            if(matrix[0][i] == 0)
            {
                flag1 = 1;
                break;
            }
        }
        for(int i = 0; i < matrix.length; i++)
        {
            if(matrix[i][0] == 0)
            {
                flag2 = 1;
                break;
            }
        }

        for(int i = 1; i < matrix.length; i++)
        {
            for(int j = 1; j < matrix[0].length; j++)
            {
                if(matrix[i][j] == 0)
                {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; i++)
        {
            for(int j = 1; j < matrix[0].length; j++)
            {
                if(matrix[i][j] != 0 && (matrix[0][j] == 0 || matrix[i][0] == 0))
                {
                    matrix[i][j] = 0;
                }
            }
        }
        if(flag1 == 1)
        {
            for(int i = 0; i < matrix[0].length; i++)
            {
                matrix[0][i] = 0;
            }
        }
        if(flag2 == 1)
        {
            for(int i = 0; i < matrix.length; i++)
            {
                matrix[i][0] = 0;
            }
        }
        
    }
}