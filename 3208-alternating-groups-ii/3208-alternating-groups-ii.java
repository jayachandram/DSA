class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int count = 0;
        int n = colors.length;
        int l = 0;
        for(int i = 1; i < n + k - 1; i++)
        {
            if(colors[(i-1) % n] == colors[i % n])
                l = i;

            if(i - l + 1 == k)
            {
                count++;
                l++;
            }
        }
        return count;
    }
}