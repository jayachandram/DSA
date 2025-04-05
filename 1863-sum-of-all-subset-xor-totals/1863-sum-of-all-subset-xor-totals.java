class Solution {
    public int subsetXORSum(int[] nums) {
        return f(nums, 0, 0);
    }
    public int f(int[] nums, int index, int currentXor)
    {
        if(index == nums.length)
            return currentXor;

        int pick = f(nums, index + 1, currentXor ^ nums[index]);
        int notPick = f(nums, index + 1, currentXor);

        return pick + notPick;
    
    }
}