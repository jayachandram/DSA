import java.util.*;

class Solution {
    public int[] closestPrimes(int left, int right) {
        // Step 1: Find all primes up to 'right' using Sieve of Eratosthenes
        boolean[] isPrime = sieve(right);

        // Step 2: Collect all primes in the given range [left, right]
        List<Integer> primes = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        // Step 3: Find the closest prime pair
        if (primes.size() < 2) return new int[]{-1, -1}; // No valid pair

        int minDiff = Integer.MAX_VALUE;
        int[] result = new int[2];

        for (int i = 1; i < primes.size(); i++) {
            int diff = primes.get(i) - primes.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
                result[0] = primes.get(i - 1);
                result[1] = primes.get(i);
            }
        }

        return result;
    }

    // Optimized Sieve of Eratosthenes
    private boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false; // 0 and 1 are not prime

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        return isPrime;
    }
}
