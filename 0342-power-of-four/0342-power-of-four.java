class Solution {
    public boolean isPowerOfFour(int n) {
        if(n <= 0) return false;
        for(int i = 0; i < 32; i++)
        {
            if(Math.pow(4, i) == n) return true;
        }
        return false;
    }
}