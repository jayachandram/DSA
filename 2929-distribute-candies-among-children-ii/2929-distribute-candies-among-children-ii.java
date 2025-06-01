class Solution {
    public long distributeCandies(int N, int l) {
        long n = (long)N;
        long limit = (long)l;
        long total_combinations = c(n, 2);
        long one_unvalid_combination = 3 * c(n - limit - 1, 2);
        long two_unvalid_combination = 3 * c(n - 2 * limit - 2, 2);
        long three_unvalid_combination = c(n- 3 * limit - 3, 2);

        long valid = total_combinations - one_unvalid_combination + two_unvalid_combination - three_unvalid_combination;

        return valid;
    }
    private long c(long n, long r)
    {
        if(n < 0) return 0;

        return (n + 1) * (n + 2) / 2;
    }
}