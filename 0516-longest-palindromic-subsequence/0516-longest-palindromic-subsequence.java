
Space optimized approach you can definitely understand if you recall in the future
class Solution {
    public int longestPalinSubseq(String s) {
        int len = s.length();
        StringBuilder str = new StringBuilder(s);
        String str1 = str.reverse().toString();
        
        int[] prev = new int[len + 1];
        int[] curr = new int[len + 1];

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len; j++) {
                if (s.charAt(i - 1) == str1.charAt(j - 1))
                    curr[j] = prev[j - 1] + 1;
                else
                    curr[j] = Math.max(prev[j], curr[j - 1]);
            }
            // Move to the next row
            prev = curr.clone();
        }
        return prev[len];
    }
}