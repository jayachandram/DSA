class Solution {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";

        StringBuilder previous = new StringBuilder("1");

        for (int i = 1; i < n; i++) {
            StringBuilder current = new StringBuilder();
            int count = 1; // We start counting from 1 (because the first character is already considered)
            for (int j = 1; j < previous.length(); j++) {
                // If the current character is the same as the previous one, increment the count
                if (previous.charAt(j) == previous.charAt(j - 1)) {
                    count++;
                } else {
                    // Append the count and the character to the result
                    current.append(count).append(previous.charAt(j - 1));
                    count = 1; // Reset count for the next character
                }
            }
            // Append the last group (because it was never added in the loop)
            current.append(count).append(previous.charAt(previous.length() - 1));
            previous = current; // Move to the next sequence
        }
        return previous.toString();
    }
}
