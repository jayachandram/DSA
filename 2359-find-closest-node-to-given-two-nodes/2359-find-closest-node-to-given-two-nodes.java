// We can optimize this in terms of optimization by reducing teh queue since there is only one out going edge from each node insted of using a queue we cam use simple while loop like we did in linked list. also we can use two seperate array insted of 2d array not much heping but looks cleaner.

// class Solution {
//     public int closestMeetingNode(int[] edges, int node1, int node2) {

//         int n = edges.length;
//         int[][] distance = new int[n][2];
//         Queue<int[]> queue = new LinkedList<>();

//         for(int i = 0; i < n; i++)
//             distance[i][0] = distance[i][1] = -1;
        
//         distance[node1][0] = 0;
//         distance[node2][1] = 0;

//         queue.add(new int[]{node1, 1});
//         queue.add(new int[]{node2, 2});

//         while(!queue.isEmpty())
//         {
//             int node = queue.peek()[0];
//             int type = queue.poll()[1];
//             int neighbor = edges[node];

//             if(neighbor != -1 && distance[neighbor][type - 1] == -1)
//             {
//                 distance[neighbor][type - 1] = distance[node][type - 1] + 1;
//                 queue.add(new int[]{neighbor, type});
//             }
//         }

//         int commanNode = -1;
//         int minDistance = 1000000;

//         for(int i = 0; i < n; i++)
//         {
//             if(distance[i][0] != -1 && distance[i][1] != -1)
//             {
//                 int max = Math.max(distance[i][0], distance[i][1]);
//                 if(max < minDistance)
//                 {
//                     minDistance = max;
//                     commanNode = i;
//                 }
//             }
//         }
//         return commanNode;
//     }
// }

class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {

        int n = edges.length;
        int[][] distance = new int[n][2];

        for(int i = 0; i < n; i++)
            distance[i][0] = distance[i][1] = -1;

        int node = node1;
        int temp = 0;
        while(node != -1 && distance[node][0] == -1)
        {
           distance[node][0] = temp++;
           node = edges[node];
        }

        node = node2;
        temp = 0;
        while(node != -1 && distance[node][1] == -1)
        {
           distance[node][1] = temp++;
           node = edges[node];
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