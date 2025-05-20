class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] difference_array = new int[nums.length + 1];

        for(int i = 0; i < queries.length; i++)
        {
            difference_array[queries[i][0]] += 1;
            difference_array[queries[i][1] + 1] -= 1;
        }

        if(difference_array[0] < nums[0])
            return false;

        for(int i = 1; i < difference_array.length-1; i++)
        {
            difference_array[i] += difference_array[i-1];

            if(difference_array[i] < nums[i])
                return false;
        }
        return true;
    }
}