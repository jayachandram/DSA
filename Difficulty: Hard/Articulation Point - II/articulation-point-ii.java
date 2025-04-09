//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.articulationPoints(V, edges);
            Collections.sort(ans);
            for (int val : ans) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static int timer = 0;
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for(int[] edge : edges)
        {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] visited = new int[V];
        int[] time = new int[V];
        int[] lowestTime = new int[V];
        int[] points = new int[V];
        ArrayList<Integer> criticalPoints = new ArrayList<>();

        for(int i = 0; i < V; i++)
        {
            if(visited[i] == 0)
                dfs(i, -1, adj, visited, time, lowestTime, points);
        }

        for(int i = 0; i < V; i++)
            if(points[i] == 1)
                criticalPoints.add(i);
        
        if(Arrays.stream(points).sum() == 0)
            criticalPoints.add(-1);
                

        return criticalPoints;
    }
    private static void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] time, int[] lowestTime, int[] points)
    {
        visited[node] = 1;
        time[node] = lowestTime[node] = timer++;
        int child = 0;
        for(Integer neighbour : adj.get(node))
        {
            if(neighbour == parent)
                continue;

            if(visited[neighbour] == 0)
            {
                dfs(neighbour, node, adj, visited, time, lowestTime, points);
                lowestTime[node] = Math.min(lowestTime[node], lowestTime[neighbour]);

                if(lowestTime[neighbour] >= time[node] && parent != -1)
                    points[node] = 1;
                child++;
            }
            else
                lowestTime[node] = Math.min(lowestTime[node], lowestTime[neighbour]);
        }
        if(child > 1 && parent == -1)
            points[node] = 1;
    }
}