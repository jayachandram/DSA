class Solution {
    public boolean ValidCorner(int mat[][]) {
        // Code here
        HashSet<String> already_seen = new HashSet<>();
        
        for(int row = 0; row < mat.length; row++)
        {
            for(int col1 = 0; col1 < mat[0].length; col1++)
            {
                if(mat[row][col1] == 0) continue;
                for(int col2 = col1 + 1; col2 < mat[0].length; col2++)
                {
                    if(mat[row][col2] == 0) continue;
                    
                    String str = col1 + "," + col2;
                    
                    if(already_seen.contains(str)) return true;
                    else already_seen.add(str);
                }
            }
        }
        return false;
    }
}