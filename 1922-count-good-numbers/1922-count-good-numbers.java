class Solution {
    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2;
        long odd = n / 2;
        long mod = 1_000_000_007;

        return (int)((modPow(5, even, mod) * modPow(4, odd, mod)) % mod);
    }

    private long modPow(long base, long power, long mod) {
        long result = 1;
        base = base % mod;

        while (power > 0) {
            if (power % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            power = power / 2;
        }
        return result;
    }
}
