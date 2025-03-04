class Solution {
    public boolean checkPowersOfThree(int n) {
        return bt(0,0,n);
    }
    static boolean bt(int i, int sum, int n)
    {
        if(sum == n)
            return true;
        if(sum > n || (int)Math.pow(3,i) > n)
            return false;

        return bt(i+1, sum + (int)Math.pow(3,i), n) || bt(i + 1, sum, n);
    }
}