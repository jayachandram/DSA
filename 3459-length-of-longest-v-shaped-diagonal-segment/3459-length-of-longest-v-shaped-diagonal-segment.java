class Solution {
    public int lenOfVDiagonal(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dirs = {{1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
        Map<String, Integer> memo = new HashMap<>();

        // DFS helper as lambda
        class Helper {
            int dfs(int i, int j, int dx, int dy, boolean turned, int expected) {
                // Out of bounds or wrong number
                if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != expected) return 0;

                String key = i + "," + j + "," + dx + "," + dy + "," + turned + "," + expected;
                if (memo.containsKey(key)) return memo.get(key);

                int res = 1;
                int nextExpected = (expected == 2 ? 0 : 2);

                // Continue straight
                res = Math.max(res, 1 + dfs(i + dx, j + dy, dx, dy, turned, nextExpected));

                // Try 90° clockwise turn if not yet turned
                if (!turned) {
                    int ndx = dy;   // rotation (dx,dy) → (dy,-dx)
                    int ndy = -dx;
                    res = Math.max(res, 1 + dfs(i + ndx, j + ndy, ndx, ndy, true, nextExpected));
                }

                memo.put(key, res);
                return res;
            }
        }

        Helper helper = new Helper();
        int ans = 0;

        // Start from every "1"
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    for (int[] d : dirs) {
                        ans = Math.max(ans, 1 + helper.dfs(i + d[0], j + d[1], d[0], d[1], false, 2));
                    }
                }
            }
        }
        return ans;
    }
}
