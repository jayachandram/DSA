class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];

        for(char ch : s.toCharArray()) freq[ch - 'a']++;
        for(char ch : t.toCharArray())
        {
            
            if(freq[ch - 'a'] != 0 ) 
                freq[ch - 'a']--;
            else
                return false;
        }

        if(Arrays.stream(freq).sum() == 0) return true;
        return false;
    }
}