class Solution {
    public int numDecodings(String digits) {
int[] dp = new int[digits.length()];
        
        return f(digits, 0, dp);
        
    }
    private int f(String digits, int index, int[] dp)
    {
        if(index == digits.length())
            return 1;
        
        if(digits.charAt(index) == '0')
            return 0;
            
        if(dp[index] != 0)
            return dp[index];
        
        int ways = f(digits, index + 1, dp);
        
        if(index < digits.length() -1)
        {
            int num = Integer.parseInt(digits.substring(index, index + 2));
            
            if(num >= 10 && num <= 26)
                ways += f(digits, index + 2, dp);
        }
        
        return dp[index]= ways;
        
    }
}