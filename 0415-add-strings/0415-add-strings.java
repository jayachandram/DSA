class Solution {
    public String addStrings(String num1, String num2) {
        int l1 = num1.length() - 1, l2 = num2.length() - 1, carry = 0;
        StringBuilder str = new StringBuilder();
        
        while(l1 >= 0 || l2 >= 0 || carry == 1)
        {
            int digit1 = l1 >= 0 ? num1.charAt(l1) - '0' : 0;
            int digit2 = l2 >= 0 ? num2.charAt(l2) - '0' : 0;
            
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