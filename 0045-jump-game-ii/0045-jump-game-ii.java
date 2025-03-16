class Solution {
    public int jump(int[] nums) {
        
        int maxReach = -1;
        int jumps = 0;
        int currentMax = 0;
        for(int currentStart = 0; currentStart < nums.length-1; currentStart++)
        {
            maxReach = Math.max(maxReach, currentStart + nums[currentStart]);
            if(maxReach >= nums.length-1)
            {
                jumps++;
                break;
            }
            if(currentStart == currentMax)
            {
                jumps++;
                currentMax = maxReach;
            }
        }
        return jumps;

    }
}