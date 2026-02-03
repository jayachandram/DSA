class Solution {
    public boolean isTrionic(int[] nums) {
        
        if(nums.length < 4) return false;
        

        for(int p = 1; p <= nums.length - 3; p++)
        {
            for(int q = p + 1; q <= nums.length - 2; q++)
            {
                boolean flag = true;
                if(p != q)
                {
                    for(int i = 0; i < p; i++)
                    {
                        if(nums[i] >= nums[i + 1]) 
                        {
                            flag = false;
                            break;
                        }
                    }

                    for(int i = p; i < q; i++)
                    {
                        if(nums[i] <= nums[i + 1]) 
                        {
                            flag = false;
                            break;
                        }
                    }
                    for(int i = q; i < nums.length - 1; i++)
                    {
                        if(nums[i] >= nums[i + 1]) 
                        {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) return true;
                   
                }
            }
        }
        return false;
    }
}