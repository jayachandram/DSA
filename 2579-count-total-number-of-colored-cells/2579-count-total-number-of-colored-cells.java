class Solution {
    public long coloredCells(int N) {
        long n = (long)N;
        return 1 + (long)4 * (n*(n-1)/2);
    }
}