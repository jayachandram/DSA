class Solution {
    public boolean isSubSeq(String s1, String s2) {
        // code here
        
        int i = 0;
        
        for(char ch : s2.toCharArray())
        {
            if(i == s1.length()) return true;
            
            if(s1.charAt(i) == ch)
            {
                i++;
            }
        }
        if(i == s1.length()) return true;
        return false;
    }
};