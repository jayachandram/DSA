class Solution {
    int countStrings(String s) {
        // code here
        int[] freq = new int[26];
        int  n = s.length();
        
        for(char ch : s.toCharArray())
            freq[ch - 'a'] += 1;
            
            
        int total_ways = n * (n - 1) / 2;
        int same_strings = 0;
        boolean bool = false;
        
        for(int frequency: freq)
            if(frequency > 1)
            {
                same_strings += frequency * (frequency - 1) / 2;
                bool = true;
            }
            
        
        return bool ? total_ways - same_strings + 1 : total_ways - same_strings;
    }
}