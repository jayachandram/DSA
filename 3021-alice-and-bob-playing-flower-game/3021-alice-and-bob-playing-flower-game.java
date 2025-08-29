class Solution {
    public long flowerGame(int n, int m) {
         long oddsInN = (n + 1L) / 2L;
        long evenInM = m / 2L;
        long count = oddsInN * evenInM;

        long evenInN = n / 2L;
        long oddsInM = (m + 1L) / 2L;
        count += evenInN * oddsInM;

        return count;
    }
}