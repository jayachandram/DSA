class Solution {
    public long countSubstrings(String s, char c) {
        
        int[] arr = new int[26];
        long count = 0;
        
        int n = s.length();
            
        for(int i = 0; i < n; i++)
            arr[s.charAt(i) - 'a'] += 1;
        
        count = (long)(arr[c - 'a'] * (long)(arr[c - 'a'] + 1) ) / (long)2;

        return count;
    }
}