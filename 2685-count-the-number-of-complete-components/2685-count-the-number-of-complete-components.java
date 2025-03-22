class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for(int i = 0; i < n; i++)
        adjacencyList.add(new ArrayList<>());
        
        for(int[] edge : edges)
        {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        int noOfCompleteComponents = 0;

        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++)
        {
            if(!visited[i])
            {
                int[] nodes = new int[1];
                int[] edge = new int[1];

                dfs(i, adjacencyList, nodes, edge, visited);

                if(edge[0] ==  nodes[0] * (nodes[0] - 1))
                    noOfCompleteComponents++;
            }
        }
        return noOfCompleteComponents;
    }

    private void dfs(int node, List<List<Integer>> adjacencyList, int[] nodes, int[] edge, boolean[] visited)
    {
        visited[node] = true;
        nodes[0]++;

        for(int neighbour : adjacencyList.get(node))
        {
            edge[0]++;
            if(!visited[neighbour])
                dfs(neighbour, adjacencyList, nodes, edge, visited);
        }
    }
}