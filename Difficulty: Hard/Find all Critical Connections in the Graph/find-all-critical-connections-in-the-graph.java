//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int V = Integer.parseInt(br.readLine().trim());
            int E = Integer.parseInt(br.readLine().trim());
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> ans = obj.criticalConnections(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.println(ans.get(i).get(0) + " " + ans.get(i).get(1));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    private int timer = 0;
    public ArrayList<ArrayList<Integer>> criticalConnections(
        int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        

        int[] visited = new int[v];
        int[] time = new int[v];
        int[] lowestTime = new int[v];

        ArrayList<ArrayList<Integer>> criticalPoints = new ArrayList<>();

        dfs(0, -1, adj, visited, time, lowestTime, criticalPoints);
        criticalPoints.sort((a, b) -> {
    if (!a.get(0).equals(b.get(0))) {
        return a.get(0) - b.get(0);
    } else {
        return a.get(1) - b.get(1);
    }
});

        return criticalPoints;
    }
    private void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] time, int[] lowestTime, ArrayList<ArrayList<Integer>> criticalPoints)
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
                {
                    int a = node < neighbour ? node : neighbour;
                    int b = node > neighbour ? node : neighbour;
                    criticalPoints.add(new ArrayList<>(Arrays.asList(a, b)));
                }
            }
            else
                lowestTime[node] = Math.min(lowestTime[node], lowestTime[neighbour]);
        }
    }
}