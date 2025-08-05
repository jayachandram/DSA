class Solution {
    public boolean isPalinSent(String s) {
        // code here
        StringBuilder str = new StringBuilder();
        for(char ch: s.toCharArray()) if(Character.isLetter(ch) || Character.isDigit(ch)) str.append(ch);
        return isPalindrome(str.toString().toLowerCase());
    }
    boolean isPalindrome(String s)
    {
        int i = 0, j = s.length() - 1;
        
        while(i < j) 
        {
            if(s.charAt(i)  != s.charAt(j)) return false;
            i++;
            j--;
        }
        
        return true;

    }
}