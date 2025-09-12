class Solution {
    public boolean doesAliceWin(String s) {
        
        int vowels = 0,n = s.length();

        for(char ch : s.toCharArray()) if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') vowels++;

        if(vowels == 0) return false;
        if(n % 2 == 1) return true;

        int left = 0;

        boolean alice = true;

        for(int right = 0; right < n; right++)
        {
            return true;
        }
        return false;
    }
}