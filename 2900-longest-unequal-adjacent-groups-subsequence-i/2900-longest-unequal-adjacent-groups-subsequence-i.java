class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {

        List<String> ans = new ArrayList<>();
        int last = 0;

        for(int i = 0; i < words.length; i++)
        {
            if(ans.size() == 0 || groups[i] != groups[last])
            {
                ans.add(words[i]);
                last = i;
            }
        }

        return ans;
    }
}