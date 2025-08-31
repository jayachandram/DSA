class Solution {
    public void solveSudoku(char[][] mat) {
        solve(mat);
    }
     static boolean solve(char[][] mat){
        
      for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                
                if(mat[i][j] == '.'){
                    for(char k = '1'; k <= '9'; k++){
                        
                        if(isSafe(mat, i, j, k)){
                            
                            mat[i][j] = k;
                            if(solve(mat)){
                                return true;
                            }
                            mat[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;   
    }
    static boolean isSafe(char[][] mat, int row, int col, char val){
        for(char k = 0; k < 9; k++){
            
            if(mat[row][k] == val) return false;
            if(mat[k][col] == val) return false;
            if(mat[3 * (row / 3) + k / 3][3 * (col/3) + k % 3] == val) return false; // 3,5
        }
        return true;
    }
}