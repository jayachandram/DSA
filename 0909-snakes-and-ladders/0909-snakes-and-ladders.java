class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int target = n * n;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n * n];
        queue.add(1);
        visited[0] = true;
        int level = 0;

        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0; i < size; i++)
            {
                int curr = queue.poll();

                if(curr == target) return level;

                for(int next = curr + 1; next <= Math.min(curr + 6, target); next++)
                {
                    int dest = next;
                    int row = (next - 1) / n;
                    int col = (next - 1) % n;
                    if(row % 2 == 1) col = n -1 - col;
                    row = n - 1- row;

                    if(board[row][col] != -1)
                        dest = board[row][col];
                    if(!visited[dest - 1])
                    {
                        queue.add(dest);
                        visited[dest - 1] = true;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}