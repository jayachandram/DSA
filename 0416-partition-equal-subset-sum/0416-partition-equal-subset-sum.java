class Solution {
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for(int i : nums)
            sum += i;
        if(sum % 2 != 0)
            return false;

        Boolean[][] dp = new Boolean[nums.length][sum/2 + 1];
        return f(nums, sum/2,0, dp);
    }
    static boolean f(int arr[], int remaining, int index, Boolean[][] dp)
    {

        if(remaining == 0)
            return true;

        if(index == arr.length || remaining < 0)
            return false;

        if(dp[index][remaining] != null)
            return dp[index][remaining];

        boolean include = f(arr, remaining - arr[index], index+1, dp);
        boolean exclude = f(arr, remaining, index+1, dp);

        return  dp[index][remaining] = include || exclude;
    }
}
