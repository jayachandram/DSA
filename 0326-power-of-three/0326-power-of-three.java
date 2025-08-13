class Solution {
    public boolean isPowerOfThree(int n) {

        if(n <= 0) return false;

        for(int i = 0; i < 32; i++) if(Math.pow(3, i) == n) return true;

        return false;
    }
}