class Solution {
    public String defangIPaddr(String address) {
        StringBuffer ans = new StringBuffer();

        for(char ch :  address.toCharArray()){
            if(ch == '.')
            {
                ans.append('[');
                ans.append('.');
                ans.append(']');
            }
            else
            {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}