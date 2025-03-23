class Solution {
    public int numDecodings(String digits) {
        int[] dp = new int[digits.length()];

        return f(digits, 0, digits.length(), dp);
        
    }
    private int f(String digits, int index, int n, int[] dp)
    {
        if(index == n)
            return 1;
        
        if(digits.charAt(index) == '0')
            return 0;
        
        if(dp[index] != 0)
            return dp[index];
        
        int ways = f(digits, index + 1, n, dp);
        
        if(index < n-1)
        {
            int num = Integer.parseInt(digits.substring(index, index + 2));
            
            if(num >= 10 && num <= 26)
                ways += f(digits, index + 2, n, dp);
        }
        
        return dp[index] = ways;
        
    }
}