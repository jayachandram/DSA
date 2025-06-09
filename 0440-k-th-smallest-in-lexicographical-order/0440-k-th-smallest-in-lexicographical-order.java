class Solution {
    public int findKthNumber(int n, int k) {
        long curr = 1;
        long steps = 0;
        k--;


        while(k != 0)
        {
            steps = countSteps(n, curr, curr + 1);

            if(steps <= k)
            {
                k -= steps;
                curr++;
            }
            else
            {
                curr = curr * 10;
                k--;
            }
        }
        return (int)curr;
    }
    private long countSteps(int n, long p1, long p2)
    {
        long steps = 0;
        while(p1 <= n)
        {
            steps += Math.min(n + 1, p2) - p1;
            p1 = p1 * 10;
            p2 = p2 * 10;
        }
        return steps;
    }
}