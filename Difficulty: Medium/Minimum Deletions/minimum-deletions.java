class Solution {
    static int minDeletions(String s) {
        // code here
        int[][] dp = new int[s.length()][s.length()];
        
        for(int[] i : dp)
            Arrays.fill(i, -1);
            
        return f(s, 0, s.length() - 1, dp);
    }
    private static int f(String s, int start, int end, int[][] dp)
    {
        if(start >= end)
            return 0;
            
        if(dp[start][end] != -1)
            return dp[start][end];
            
        if(s.charAt(start) == s.charAt(end))
            return f(s, start + 1, end - 1, dp);
        
        return dp[start][end] = 1 + Math.min(f(s, start + 1, end, dp), f(s, start, end - 1, dp));
    }
}