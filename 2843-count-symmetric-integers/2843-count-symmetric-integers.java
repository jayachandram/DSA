class Solution {
    public int countSymmetricIntegers(int low, int high) {

        int count = 0;

        for(int i = low; i <= high; i++)
            if(f(i))
                count++;
        
        return count;
    }
    private boolean f(int i)
    {
        String num = Integer.toString(i);

        if(num.length() % 2 == 1)
            return false;
        
        int len = num.length();
        int left = 0, right = 0;

        for(int ch = 0; ch < len / 2; ch++)
        {
            left += num.charAt(ch) - '0';
        }
        for(int ch = len/2; ch < len; ch++)
        {
            right += num.charAt(ch) - '0';
        }
        return left == right;
    }
}