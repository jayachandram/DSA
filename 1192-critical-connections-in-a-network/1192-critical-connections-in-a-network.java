class Solution {
    private int timer = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for(List<Integer> connection : connections)
        {
            adj.get(connection.get(0)).add(connection.get(1));
            adj.get(connection.get(1)).add(connection.get(0));
        }

        int[] visited = new int[n];
        int[] time = new int[n];
        int[] lowestTime = new int[n];

        List<List<Integer>> criticalPoints = new ArrayList<>();

        dfs(0, -1, adj, visited, time, lowestTime, criticalPoints);

        return criticalPoints;
    }
    private void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] time, int[] lowestTime, List<List<Integer>> criticalPoints)
    {
        visited[node] = 1;
        time[node] = lowestTime[node] = timer++;

        for(Integer neighbour : adj.get(node))
        {
            if(neighbour == parent)
                continue;

            if(visited[neighbour] == 0)
            {
                dfs(neighbour, node, adj, visited, time, lowestTime, criticalPoints);
                lowestTime[node] = Math.min(lowestTime[node], lowestTime[neighbour]);

                if(lowestTime[neighbour] > time[node])
                    criticalPoints.add(new ArrayList<>(Arrays.asList(node, neighbour)));
            }
            else
                lowestTime[node] = Math.min(lowestTime[node], lowestTime[neighbour]);
        }
    }
}