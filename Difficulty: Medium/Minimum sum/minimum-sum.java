class Solution {
    String minSum(int[] arr) {
        // code here
        
        int[] count = new int[10];
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        boolean even = true;
        
        for(int num : arr) count[num]++;
        
        for(int num = 0; num < 10; num++)
        {
            while(count[num] > 0)
            {
                if(even)
                {
                    if(!(str1.length() == 0 && num == 0)) str1.append(num);
                    even = false;
                }
                else
                {
                    if(!(str2.length() == 0 && num == 0)) str2.append(num);
                    even = true;
                }
                --count[num];
            }
        }
        
        return addStrings(str1, str2);
    }
    private String addStrings(StringBuilder str1, StringBuilder str2)
    {
        int i = str1.length() - 1, j = str2.length() -1, carry = 0;
        StringBuilder ans = new StringBuilder();
        
        while(i >= 0 || j >= 0 || carry > 0)
        {
            int digit1 = i < 0 ? 0 : str1.charAt(i) - '0';
            int digit2 = j < 0 ? 0 : str2.charAt(j) - '0';
            int sum = digit1 + digit2 + carry;
            
            int lastDigit = sum % 10;
            carry = sum / 10;
            
            ans.append(lastDigit);
            i--;
            j--;
        }
        return ans.reverse().toString();
    }
}
