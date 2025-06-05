class Solution {
    public int countPaths(int[][] edges, int V, int src, int dest) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges) adj.get(edge[0]).add(edge[1]);
        int[] dp = new int[V];
        Arrays.fill(dp, -1);
        return dfs(src, dest, adj, dp);
    }
    private int dfs(int curr_node, int target, ArrayList<ArrayList<Integer>> adj, int[] dp)
    {
        if(curr_node == target) return 1;
        if(dp[curr_node] != -1) return dp[curr_node];
        int total = 0;
        for(int nei : adj.get(curr_node)) total += dfs(nei, target, adj, dp);
        dp[curr_node] = total;
        return dp[curr_node];
    }
}