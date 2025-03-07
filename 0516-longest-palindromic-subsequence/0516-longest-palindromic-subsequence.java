class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        StringBuilder str = new StringBuilder(s);
        String str1 = str.reverse().toString();
        String str2 = s;
        
        int[][] dp = new int[len+1][len+1];
        
        for(int i = 1; i <= len; i++)
        {
            for(int j = 1; j <= len; j++)
            {
                if(str1.charAt(i - 1) == (str2.charAt(j - 1)))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[len][len];
    }
}