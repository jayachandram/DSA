public class Solution {
    public long kMirror(int k, int n) {
        long sum = 0;
        int count = 0;
        int len = 1;

        while (count < n) {
            // Generate all palindromes of length len
            for (long num : generatePalindromes(len)) {
                if (isPalindrome(convertToBaseK(num, k))) {
                    sum += num;
                    count++;
                    if (count == n) return sum;
                }
            }
            len++;
        }

        return sum;
    }

    // ✅ Step 1: Generate all base-10 palindromes of a given length
    List<Long> generatePalindromes(int n) {
        List<Long> result = new ArrayList<>();
        int half = (n + 1) / 2;

        long start = (long)Math.pow(10, half - 1);
        long end = (long)Math.pow(10, half);

        for (long i = start; i < end; i++) {
            String firstHalf = Long.toString(i);
            StringBuilder sb = new StringBuilder(firstHalf);

            if (n % 2 == 1) {
                sb.setLength(sb.length() - 1); // avoid repeating the middle digit
            }

            String pal = firstHalf + sb.reverse().toString();
            result.add(Long.parseLong(pal));
        }

        return result;
    }

    // ✅ Step 2: Convert number to base-k manually
    String convertToBaseK(long num, int k) {
        if (num == 0) return "0";

        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            sb.append(num % k);
            num /= k;
        }

        return sb.reverse().toString();
    }

    // ✅ Step 3: Check if a string is a palindrome
    boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    // \U0001f504 Optional main method for quick testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.kMirror(2, 5)); // Output: 25
    }
}
