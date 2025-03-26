class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length()];

        return f(s, wordDict, 0, s.length(), dp);
    }
    private boolean f(String s, List<String>  dict, int index, int n, boolean[] dp)
    {
        if(index >= n)
            return true;
        
        if(dp[index])
            return true;

        for(int i = 0; i < dict.size(); i++)

            if(index + dict.get(i).length() <= n && s.substring(index,(index + dict.get(i).length())).equals(dict.get(i)))

               if(f(s, dict, index + dict.get(i).length(), n, dp))

                    return dp[index] = true;

        return dp[index] = false;
    }
}