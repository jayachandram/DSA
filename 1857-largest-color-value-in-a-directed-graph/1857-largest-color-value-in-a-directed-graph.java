class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++)
            adj.get(edges[i][0]).add(edges[i][1]);

        int[][] dp = new int[n][26];
        boolean[] visited = new boolean[n];
        boolean[] path = new boolean[n];

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int val = dfs(i, adj, visited, path, dp, colors);
            if (val == -1) return -1;
            ans = Math.max(ans, val);
        }

        return ans;
    }

    private int dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] path, int[][] dp, String colors) {
        if (path[node]) return -1; // cycle detected
        if (visited[node]) {
            int max = 0;
            for (int c = 0; c < 26; c++)
                max = Math.max(max, dp[node][c]);
            return max;
        }

        visited[node] = true;
        path[node] = true;

        for (int nei : adj.get(node)) {
            int res = dfs(nei, adj, visited, path, dp, colors);
            if (res == -1) return -1;
            for (int c = 0; c < 26; c++)
                dp[node][c] = Math.max(dp[node][c], dp[nei][c]);
        }

        dp[node][colors.charAt(node) - 'a']++;

        path[node] = false;

        int maxColor = 0;
        for (int c = 0; c < 26; c++)
            maxColor = Math.max(maxColor, dp[node][c]);
        return maxColor;
    }
}
