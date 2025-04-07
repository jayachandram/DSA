//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
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
            boolean ans = obj.isCyclic(V, edges);
            System.out.println(ans ? "true" : "false");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        
        for(int i = 0; i < V; i++)
            adjacencyList.add(new ArrayList<>());
            
        for(int[] edge : edges)
            adjacencyList.get(edge[0]).add(edge[1]);
        
        int[] visitedNode = new int[V];
        int[] visitedPath = new int[V];
        
        for(int i = 0; i < V; i++)
            if(visitedNode[i] == 0)
                if(dfs(i, visitedNode, visitedPath, adjacencyList))
                    return true;
                
        return false;
    }
    private boolean dfs(int node, int[] visitedNode, int[] visitedPath, ArrayList<ArrayList<Integer>> adjacencyList)
    {
        visitedNode[node] = 1;
        visitedPath[node] = 1;
    
        
        for(Integer neighbour : adjacencyList.get(node))
        {
            if(visitedNode[neighbour] == 0)
            {
                if(dfs(neighbour, visitedNode, visitedPath, adjacencyList))
                    return true;
            }
            else if(visitedPath[neighbour] == 1)
                    return true;
        }
        visitedPath[node] = 0;
        return false;
    }
}