class Solution {
    void selectionSort(int[] nums) {
        // code here
        
        int len = nums.length;
        
        for(int i = 0; i < len; i++)
        {
            int minIndex = i;
            
            for(int j = i + 1; j < len; j++)
            {
                if(nums[j] < nums[minIndex])
                {
                    minIndex = j;
                }
            }
            
            if(minIndex != i)
            {
                int temp = nums[minIndex];
                nums[minIndex] = nums[i];
                nums[i] = temp;
            }
        }

        //return nums;
    }
}