class Solution {
    public boolean isSumString(String s) {
        // code here
        int n = s.length();
        
        for(int i = 1; i < n; i++)
            for(int j = 1; i + j < n; j++)
                if(isValid(s, 0, i, j))
                    return true;
        
        return false;
    }
    private boolean isValid(String s, int beg, int l1, int l2)
    {
        String s1 = s.substring(beg, beg + l1);
        String s2 = s.substring(beg + l1, beg + l1 + l2);
        String addSum = addStrings(s1, s2);
        int sumLength = addSum.length();
        
        if(beg + l1 + l2 + sumLength > s.length()) return false;
        
        if(s.substring(beg + l1 + l2, beg + l1 + l2 + sumLength).equals(addSum))
        {    
            if(beg + l1 + l2 + sumLength == s.length()) return true;
            return isValid(s, beg + l1, l2, sumLength);
        }
        return false;
    }
    private String addStrings(String s1, String s2)
    {
        int l1 = s1.length() - 1, l2 = s2.length() - 1, carry = 0;
        StringBuilder str = new StringBuilder();
        
        while(l1 >= 0 || l2 >= 0 || carry == 1)
        {
            int digit1 = l1 >= 0 ? s1.charAt(l1) - '0' : 0;
            int digit2 = l2 >= 0 ? s2.charAt(l2) - '0' : 0;
            
            int sum = digit1 + digit2 + carry;
            int num = sum % 10;
            carry = sum / 10;
            str.insert(0, num);
            l1--;
            l2--;
        }
        return str.toString();
    }
}