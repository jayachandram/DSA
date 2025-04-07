class Solution {
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for(int i : nums)
            sum += i;
        if(sum % 2 != 0)
            return false;

        boolean[][] dp = new boolean[nums.length][sum];
        return f(nums, sum/2,0,0, dp);
    }
    static boolean f(int arr[], int target, int currentSum, int index, boolean[][] dp)
    {

        if(currentSum == target)
            return true;
            
        if(index == arr.length)
            return false;

        if(dp[index][currentSum])
            return dp[index][currentSum];

        if(index > arr.length - 1 || currentSum > target)
        {
            return false;
        }

        return  dp[index][currentSum] = f(arr, target, currentSum + arr[index], index+1, dp) || f(arr, target, currentSum, index+1, dp);
    }
}