class Solution {
    public int perfectSum(int[] nums, int target) {
        Integer[][] dp = new Integer[target + 1][nums.length];
        return f(nums, target, 0, 0, dp);
    }

    private int f(int[] nums, int target, int sum, int index, Integer[][] dp) {
        if (index == nums.length) return sum == target ? 1 : 0;

        if (dp[sum][index] != null) return dp[sum][index];

        int include = 0;
        if (sum + nums[index] <= target) {
            include = f(nums, target, sum + nums[index], index + 1, dp);
        }
        int exclude = f(nums, target, sum, index + 1, dp);

        return dp[sum][index] = include + exclude;
    }
}
