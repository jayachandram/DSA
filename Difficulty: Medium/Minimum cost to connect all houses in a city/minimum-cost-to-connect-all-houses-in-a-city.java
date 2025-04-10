//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] edge = new int[n][2];
            for (int i = 0; i < n; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res = obj.minCost(edge);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends




class Solution {

    public int minCost(int[][] houses) {
        // code here
        int n = houses.length;
        int minimumCost = 0;
        
        PriorityQueue<ArrayList<Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(0)));
        boolean[] visited = new boolean[n];
        
        minHeap.add(new ArrayList<>(Arrays.asList(0, 0)));
        
        while(!minHeap.isEmpty())
        {

            ArrayList<Integer> pair =  minHeap.poll();
            
            int cost = pair.get(0);
            int neighbour = pair.get(1);
            
            if(visited[neighbour])
                continue;
            
            visited[neighbour] = true;
            minimumCost += cost;
            
            for(int node = 0; node < n; node++)
            {
                if(!visited[node])
                {
                    int currentCost = Math.abs(houses[neighbour][0] - houses[node][0]) + Math.abs(houses[neighbour][1] - houses[node][1]);
                    minHeap.add(new ArrayList<>(Arrays.asList(currentCost, node)));
                }
            }
        }
        
        return minimumCost;
        
    }
}
