class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return f(nums, 0, memo);
    }

    private int f(int[] nums, int index, int[] memo) {
        if (index >= nums.length) return 0; 

        if (memo[index] != -1) return memo[index]; 

       
        int robThisHouse = nums[index] + f(nums, index + 2, memo);
        int skipThisHouse = f(nums, index + 1, memo);

        memo[index] = Math.max(robThisHouse, skipThisHouse);
        return memo[index];
    }
}