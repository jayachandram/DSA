//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int V = Integer.parseInt(sc.nextLine());
            int E = Integer.parseInt(sc.nextLine());

            List<int[]> edgeList = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                String[] parts = sc.nextLine().split(" ");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                int w = Integer.parseInt(parts[2]);
                edgeList.add(new int[] {u, v, w});
                edgeList.add(new int[] {v, u, w});
            }

            int[][] edges = new int[edgeList.size()][3];
            for (int i = 0; i < edgeList.size(); i++) {
                edges[i] = edgeList.get(i);
            }

            int src = Integer.parseInt(sc.nextLine());

            Solution obj = new Solution();
            int[] res = obj.dijkstra(V, edges, src);

            for (int val : res) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
        
        for(int[] edge : edges)
        {
            int u    = edge[0];
            int v    = edge[1];
            int cost = edge[2];
            
            adj.get(u).add(new ArrayList<>(Arrays.asList(v, cost)));
            adj.get(v).add(new ArrayList<>(Arrays.asList(u, cost)));
        }
        
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        
        PriorityQueue<ArrayList<Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(0)));
        minHeap.add(new ArrayList<>(Arrays.asList(0, src)));
        
        while(!minHeap.isEmpty())
        {
            ArrayList<Integer> edge = minHeap.poll();
            int cost = edge.get(0);
            int u = edge.get(1);
            
            for(ArrayList<Integer> neighbour : adj.get(u))
            {
                int v = neighbour.get(0);
                int weight = neighbour.get(1);
                
                if(distance[v] > distance[u] + weight)
                {
                    distance[v] = distance[u] + weight;
                    minHeap.add(new ArrayList<>(Arrays.asList(distance[v], v)));
                }
            }
        }
        return distance;
        
    }
}