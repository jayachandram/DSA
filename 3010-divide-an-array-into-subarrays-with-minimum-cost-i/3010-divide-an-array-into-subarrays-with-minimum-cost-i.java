class Solution {
    public int minimumCost(int[] nums) {
        
        int ans = nums[0];
        nums[0] = -1;
        Arrays.sort(nums);

        return ans + nums[1] + nums[2];
    }
}