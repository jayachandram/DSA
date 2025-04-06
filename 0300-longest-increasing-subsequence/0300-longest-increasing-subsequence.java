class Solution {
    public int lengthOfLIS(int[] nums) {
        int max = 1;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for(int i = 0; i < nums.length; i++)
        {
            for(int prev = 0; prev < i; prev++)
            {
                if(nums[prev] < nums[i])
                
                    dp[i] = Math.max(dp[i], dp[prev] + 1);
            }
            max = Math.max(max, dp[i]);
        }  
        return max;
    }
}