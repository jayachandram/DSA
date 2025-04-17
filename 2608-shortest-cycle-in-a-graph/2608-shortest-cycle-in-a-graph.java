class Solution {
    public int findShortestCycle(int V, int[][] edges) {
       Map<Integer, ArrayList<ArrayList<Integer>>> adj = new HashMap<>();
        boolean[] visited = new boolean[V];
        
        for(int i = 0; i < V; i++)
            adj.put(i, new ArrayList<>());
            
        for(int[] edge : edges)
        {
            ArrayList<Integer> e1 = new ArrayList<>();
            e1.add(edge[1]);
            adj.get(edge[0]).add(e1);
            
            ArrayList<Integer> e2 = new ArrayList<>();
            e2.add(edge[0]);
            adj.get(edge[1]).add(e2);
        }
        
        int[] min = new int[]{Integer.MAX_VALUE};
        
        for(int i = 0; i < V; i++){
            Arrays.fill(visited, false); 
            dfs(i, i, -1, 0, adj, min, visited);
        }
        
        return min[0] == Integer.MAX_VALUE ? -1 : min[0];
    }
    private void dfs(int start, int current, int parent, int count, Map<Integer, ArrayList<ArrayList<Integer>>> adj, int[] min, boolean[] visited)
    {
        visited[current] = true;
        
        for (ArrayList<Integer> neighbor : adj.get(current))
        {
            int next = neighbor.get(0);
            
            if(!visited[next])
            {
                dfs(start,  next, current, count + 1, adj, min, visited);
            }
            else if(next != parent && next == start && count > 1)
            {
                if(min[0] > count + 1)
                    min[0] = count + 1;
            }
        }
        visited[current] = false;
    }
};