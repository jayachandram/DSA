class Solution {
    public int maximum69Number (int num) {

        StringBuilder str = new StringBuilder(String.valueOf(num));
        int index = 0;

        for(char ch : str.toString().toCharArray())
        {
            if(ch == '6')
            {
                str.setCharAt(index, '9');
                return Integer.parseInt(str.toString());
            }
            index++;
        }
        return num;
    }
}