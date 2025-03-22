//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int e;
            e = Integer.parseInt(br.readLine());

            int v;
            v = Integer.parseInt(br.readLine());

            int[][] edges = IntMatrix.input(br, e, 2);

            Solution obj = new Solution();
            int res = obj.findNumberOfGoodComponent(e, v, edges);

            System.out.println(res);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends



class Solution {
    public static int findNumberOfGoodComponent(int e, int v, int[][] edges) {
        // code hereList<List<Integer>> adjacencyList = new ArrayList<>();
        
        List<List<Integer>> adjacencyList = new ArrayList<>();
        
        for(int i = 0; i <= v; i++)
            adjacencyList.add(new ArrayList<>());
        
        for(int[] edge : edges)
        {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        int noOfCompleteComponents = 0;

        boolean[] visited = new boolean[v+2];

        for(int i = 1; i <= v; i++)
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

    static void dfs(int node, List<List<Integer>> adjacencyList, int[] nodes, int[] edge, boolean[] visited)
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