class Solution {
    ArrayList<Integer> search(String pattern, String text) {
        // Code here
        ArrayList<Integer> result = new ArrayList<>();

        int d = 256; // Number of characters in ASCII
        int q = 101; // A prime number used for modulo to reduce hash collisions

        int m = pattern.length(); // Length of pattern
        int n = text.length();    // Length of text

        int patternHash = 0; // Hash value for pattern
        int windowHash = 0;  // Hash value for current window of text
        int h = 1;           // Multiplier for leading digit in rolling hash

        // Edge case: pattern longer than text
        if (m > n) return result;

        // Precompute h = pow(d, m-1) % q
        for (int i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        // Calculate initial hash values for pattern and first window of text
        for (int i = 0; i < m; i++) {
            patternHash = (d * patternHash + pattern.charAt(i)) % q;
            windowHash = (d * windowHash + text.charAt(i)) % q;
        }

        // Slide the pattern over the text one character at a time
        for (int i = 0; i <= n - m; i++) {

            // If the hash values match, check characters one by one
            if (patternHash == windowHash) {
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                // If full match found, add index (1-based)
                if (match) {
                    result.add(i + 1);
                }
            }

            // Update the window hash for next substring
            if (i < n - m) {
                // Remove leading character, add trailing character
                windowHash = (d * (windowHash - text.charAt(i) * h) + text.charAt(i + m)) % q;

                // Make sure hash is not negative
                if (windowHash < 0)
                    windowHash += q;
            }
        }
        return result;
    }
}