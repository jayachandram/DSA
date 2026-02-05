class Solution {
    public int[] constructTransformedArray(int[] nums) {
        
        int n = nums.length;

        int[] arr = new int[n];

        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] > 0)
            {
                arr[i] = nums[(i + nums[i]) % n];
            }
            else if(nums[i] < 0)
            {
                int index = (i + nums[i]) % n;
                if(index < 0)
                {
                    index += n;
                }
                arr[i] = nums[index];
            }
            else
            arr[i] = 0;
        }
        return arr;
    }
}