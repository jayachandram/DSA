class Solution {
    public int longestBalanced(int[] nums) {
        
        int ans = 0, i, j;
        for(i = 0; i < nums.length; i++)
        {
            HashSet<Integer> even = new HashSet<>();
            HashSet<Integer> odd = new HashSet<>();

            for(j = i; j < nums.length; j++)
            {
                if((nums[j] & 1) == 0) even.add(nums[j]);
                else odd.add(nums[j]);
                if(even.size() == odd.size()) ans = Math.max(ans, j - i + 1);
            }
            if(even.size() == odd.size()) ans = Math.max(ans, j - i);
        }
        return ans;
    }
}