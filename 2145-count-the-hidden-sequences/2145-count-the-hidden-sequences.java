class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long min = 0;
        long max = 0;
        long curr = 0;

        for(int num : differences)
        {
            curr += num;
            min = Math.min(curr, min);
            max = Math.max(curr, max);
        }
        int cnt = (int)(upper - lower) - (int)(max - min) + 1;
        return cnt > 0 ? cnt : 0;
    }
}