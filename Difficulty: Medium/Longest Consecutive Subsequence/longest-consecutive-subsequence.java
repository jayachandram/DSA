class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] nums) {
        // code here
         HashSet<Integer> set = new HashSet<>();
        int ans = 0;
        for(int num : nums) set.add(num);

        for(int num : nums)
        {
            if(set.contains(num) && !set.contains(num - 1))
            {
                int curr = num, cnt = 0;
                while(set.contains(curr))
                {
                    set.remove(curr);
                    curr++;
                    cnt++;
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}