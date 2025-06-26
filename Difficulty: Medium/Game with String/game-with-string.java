class Solution {
    public int minValue(String s, int k) {
        // code here
        int[] freq = new int[26];
        
        for(char ch : s.toCharArray()) freq[ch - 'a']++;
        
        int[] freqAtIthIndex = new int[s.length() + 1];
        
        for(int count : freq) if(count > 0) freqAtIthIndex[count]++;
        
        for(int i = s.length(); i > 0; i--)
        {
            while(freqAtIthIndex[i] > 0 && k > 0)
            {
                freqAtIthIndex[i]--;
                freqAtIthIndex[i - 1]++;
                k--;
            }
        }
        
        int result = 0;
        for (int i = 1; i <= s.length(); i++) {
            result += freqAtIthIndex[i] * i * i;
        }
                
        return result;
    }
}