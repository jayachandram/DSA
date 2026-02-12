class Solution {
    public int longestBalanced(String s) {
        
        int[] freq = new int[26];
        int ans = 0, max = 0, chars = 0;
        for(int i = 0; i < s.length(); i++)
        {
            max = 0;chars = 0;
            Arrays.fill(freq, 0);
            for(int j = i; j < s.length(); j++)
            {
                char ch = s.charAt(j);

                freq[ch - 'a']++;

                if(freq[ch - 'a'] == 1)
                    chars++;

                max = Math.max(max, freq[ch - 'a']);

                if(chars * max == j - i + 1) ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }
}