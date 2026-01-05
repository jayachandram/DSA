class Solution {
    void selectionSort(int[] nums) {
        // code here
        int len = nums.length;
        for(int i = 0; i < len; i++)
        {
            for(int j = i + 1; j < len; j++)
            {
                if(nums[j] < nums[i])
                {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        //return nums;
    }
}