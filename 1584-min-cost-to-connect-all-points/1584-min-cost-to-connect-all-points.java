class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
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
                    int currentCost = Math.abs(points[neighbour][0] - points[node][0]) + Math.abs(points[neighbour][1] - points[node][1]);
                    minHeap.add(new ArrayList<>(Arrays.asList(currentCost, node)));
                }
            }
        }
        
        return minimumCost;
        
    }
}
