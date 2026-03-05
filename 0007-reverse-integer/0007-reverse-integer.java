class Solution {
    public int reverse(int x) {
        
        long ans = 0;
        boolean neg = x < 0;
        if(neg) x = x * -1;

        while(x > 0)
        {
            int digit = x % 10;
            ans = ans* 10 +  (long)digit;
            x = x/10;
        }
        if(neg)
        {
            if(-ans < Integer.MIN_VALUE) return 0;
            else 
                return (int)-ans;
        }
        else
        {
            if(ans > Integer.MAX_VALUE) return 0;
            else
                return (int)ans;
        }
    }
}