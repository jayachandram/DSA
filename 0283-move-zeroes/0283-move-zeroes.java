class Solution {
    public void moveZeroes(int[] nums) {
        int temp=0,j=0;
     for(int i = 0;i < nums.length;i++)
     {
        if(nums[i] == 0)
        {
            temp++;
        }
     }   
     for(int i = 0;i < nums.length;i++)
     {
        if(nums[i] != 0)
        {
            nums[j] = nums[i];
            j++;
        }
     }
     for(int i = nums.length - temp;i < nums.length;i++)
     {
        nums[i] = 0;
     }
    }
}