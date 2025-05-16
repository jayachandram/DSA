class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        
        List<String> ans = new ArrayList<>();
        int prev = -1;
        String prev_str = words[0];

        for(int i = 0; i < words.length; i++)
        {
            if(groups[i] != prev && words[i].length() == prev_str.length())
            {
                ans.add(words[i]);
                prev = groups[i];
                prev_str = words[i];
            }
        }
        return ans;
    }
}