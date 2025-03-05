class Solution {
    public long coloredCells(int N) {
        long n = (long)N;
        return 1 + 4 * (n*(n-1)/2);
    }
}