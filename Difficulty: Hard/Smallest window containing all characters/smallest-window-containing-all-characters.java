import java.util.*;

class Solution {
    public String smallestWindow(String s, String p) {
        if (s.length() < p.length()) return "";

        int[] need = new int[26]; // frequency of chars in p
        int[] window = new int[26]; // frequency of current window
        int required = p.length(); 
        int formed = 0;

        for (char c : p.toCharArray()) {
            need[c - 'a']++;
        }

        int left = 0, minLen = Integer.MAX_VALUE, start = -1;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window[c - 'a']++;

            // count only if still needed
            if (need[c - 'a'] > 0 && window[c - 'a'] <= need[c - 'a']) {
                formed++;
            }

            // when all chars matched, try to shrink window
            while (formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                // shrink from left
                char leftChar = s.charAt(left);
                if (need[leftChar - 'a'] > 0 && window[leftChar - 'a'] <= need[leftChar - 'a']) {
                    formed--;
                }
                window[leftChar - 'a']--;
                left++;
            }
        }

        return (start == -1) ? "" : s.substring(start, start + minLen);
    }
}
