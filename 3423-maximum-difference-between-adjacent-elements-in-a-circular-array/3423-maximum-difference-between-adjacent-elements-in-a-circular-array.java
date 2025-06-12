class Solution {
    public int maxAdjacentDistance(int[] nums) {

        int ans = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length-1;i++)
            ans = Math.max(ans, Math.abs(nums[i] - nums[i + 1]));

        return ans = Math.max(ans, Math.abs(nums[0] - nums[nums.length - 1]));
    }
}