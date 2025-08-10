class Solution {
    public int countPS(String s) {
        int n = s.length();
        int count = 0;

        for (int centre = 0; centre < n; centre++) 
        {
            count += expandFromCentre(s, centre, centre);

            count += expandFromCentre(s, centre, centre + 1);
        }
        return count;
    }

    private int expandFromCentre(String s, int left, int right) {
        int cnt = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (right - left + 1 >= 2) cnt++; // length >= 2
            left--;
            right++;
        }
        return cnt;
    }
}
