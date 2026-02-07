class Solution {
    void pushZerosToEnd(int[] nums) {
        // code here
        int zeros = 0;
        for(int i = 0; i < nums.length; i++) if(nums[i] == 0) zeros++;

        int i = 0;
        for(int j = 0; j < nums.length; j++)
        {
            if(nums[j] != 0)
            {
                nums[i++] = nums[j];
            }
        }
        for(int j = nums.length - zeros; j < nums.length; j++) nums[j] = 0;
    }
}