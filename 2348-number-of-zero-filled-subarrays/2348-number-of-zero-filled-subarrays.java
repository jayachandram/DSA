class Solution {
    public long zeroFilledSubarray(int[] nums) {
        
        long ans = 0;
        int i = 0, j = 0;

        for(i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0)
            { 
                for(j = i; j < nums.length; j++)
                {
                    if(nums[j] != 0) break;
                }
                long n = j - i;
                ans += n * (n + 1) / 2;
                i = j;
            }
        }
        if(nums[nums.length - 1] == 0)
        {
            int n = j - i;
            ans += n * (n + 1)/2;
        }
        return ans;
    }
}