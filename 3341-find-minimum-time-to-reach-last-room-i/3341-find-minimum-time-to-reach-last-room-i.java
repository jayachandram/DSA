public class Solution {
    public int minimumTime(int[][] time) {
        int n = time.length;
        int m = time[0].length;
        int[][] visited = new int[n][m];
        for (int[] row : visited) Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0}); // {currentTime, x, y}
        visited[0][0] = 0;

        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int t = cur[0], x = cur[1], y = cur[2];

            if (x == n - 1 && y == m - 1) return t;

            for (int[] d : dir) {
                int nx = x + d[0], ny = y + d[1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    int nt = Math.max(t + 1, time[nx][ny]);
                    if (visited[nx][ny] > nt) {
                        visited[nx][ny] = nt;
                        pq.offer(new int[]{nt, nx, ny});
                    }
                }
            }
        }

        return -1;
    }
}
