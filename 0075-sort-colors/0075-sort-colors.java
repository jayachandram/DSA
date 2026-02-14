class Solution {
    public void sortColors(int[] nums) {
        int zeros = 0;
        int ones = 0;
        
        for(int num : nums)
        {
            if(num == 0)
                zeros++;
            else if(num == 1)
                ones++;
        }
        
        for(int i = 0; i < nums.length; i++)
        {
            if(i < zeros) 
            {
                nums[i] = 0;
            }
            else if(i < zeros + ones) nums[i] = 1;
            else nums[i] = 2;
        }
    }
}