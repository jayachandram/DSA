class Solution {
    public int numberOfWays(int n, int x) {

        ArrayList<Integer> powers = new ArrayList<>();
        for(int i = 1; i <= n; i++)
        {
            if(Math.pow(i, x) > n)  break;

            powers.add((int)(Math.pow(i, x)));
        }
        int[][] dp = new int[powers.size() + 1][n + 1];
        for(int[] row : dp) Arrays.fill(row, -1);

        return function(n, powers, 0, dp);
    }
    private int function(int m, ArrayList<Integer> powers, int index, int[][] dp)
    {
        if(m == 0) return 1;

        if(index == powers.size() || m < 0) return 0;

        if(dp[index][m] != -1) return dp[index][m];

        int skip = function(m, powers, index + 1, dp) % 1000000009;
        int pick = function(m - powers.get(index), powers, index + 1, dp) % 1000000009;

        return dp[index][m] = (skip + pick) % 1000000009;
    }
}