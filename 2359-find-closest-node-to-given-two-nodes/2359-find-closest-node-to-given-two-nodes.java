class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {

        int n = edges.length;
        int[][] distance = new int[n][2];
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < n; i++)
            distance[i][0] = distance[i][1] = -1;
        
        distance[node1][0] = 0;
        distance[node2][1] = 0;

        queue.add(new int[]{node1, 1});
        queue.add(new int[]{node2, 2});

        while(!queue.isEmpty())
        {
            int node = queue.peek()[0];
            int type = queue.poll()[1];
            int neighbor = edges[node];

            if(neighbor != -1 && distance[neighbor][type - 1] == -1)
            {
                distance[neighbor][type - 1] = distance[node][type - 1] + 1;
                queue.add(new int[]{neighbor, type});
            }
        }

        int commanNode = -1;
        int minDistance = 1000000;

        for(int i = 0; i < n; i++)
        {
            if(distance[i][0] != -1 && distance[i][1] != -1)
            {
                int max = Math.max(distance[i][0], distance[i][1]);
                if(max < minDistance)
                {
                    minDistance = max;
                    commanNode = i;
                }
            }
        }
        return commanNode;
    }
}