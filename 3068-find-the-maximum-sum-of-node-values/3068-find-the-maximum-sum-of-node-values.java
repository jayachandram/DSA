class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {

        int[] new_nums = new int[nums.length];
        int sum = 0;

        for(int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            new_nums[i] = (nums[i] ^ k) - nums[i];
        }
        
        Arrays.sort(new_nums);

        for(int i = nums.length - 1; i > 0; i = i - 2)
        {
            int temp = new_nums[i] + new_nums[i - 1];

            if(temp <= 0)
                break;

            sum += temp;

        }
        return sum;
    }
}