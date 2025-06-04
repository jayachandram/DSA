class Solution {
    int lcsOf3(String s1, String s2, String s3) {
        // code here
        int x = s1.length(), y = s2.length(), z = s3.length();
        int[][][] dp = new int[x][y][z];
        
        for(int[][] mat : dp)
            for(int row[] : mat)
                Arrays.fill(row, -1);
        return f(s1, s2, s3, dp, x - 1, y - 1, z - 1);
    }
    private int f(String s1, String s2, String s3, int[][][]dp, int x, int y, int z)
    {
        if(x == -1 || y == -1 || z == -1) return 0;
        if(dp[x][y][z] != -1) return dp[x][y][z];
        if(s1.charAt(x) == s2.charAt(y) && s2.charAt(y) == s3.charAt(z)) return dp[x][y][z] = 1 + f(s1, s2, s3, dp, x -1, y -1, z -1);
        else return dp[x][y][z] =  Math.max(Math.max(f(s1, s2, s3, dp, x - 1, y, z), f(s1, s2, s3, dp, x, y - 1, z)), f(s1, s2, s3, dp, x, y, z - 1));
    }
}