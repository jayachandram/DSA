class Solution {
    public int findKRotation(int nums[]) {
        // Code here
        
        
        for(int i = 0; i < nums.length - 1; i++)
        {
            if(nums[i] > nums[i + 1]) return i + 1;
        }
        
        return 0;
        
    }
}