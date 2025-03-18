class Solution {
    public int longestNiceSubarray(int[] nums) {
        int currentSum = 0, xor = 0;
        int ans = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++)
        {
            currentSum += nums[right];
            xor ^= nums[right];

            while(currentSum != xor)
            {
                currentSum -= nums[left];
                xor ^= nums[left];
                left++;
            }
            ans = Math.max(right - left + 1,ans);
        }
        return ans;

    }
}