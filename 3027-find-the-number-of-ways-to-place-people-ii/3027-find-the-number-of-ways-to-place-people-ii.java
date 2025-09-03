class Solution {
    public int numberOfPairs(int[][] points) {
        // 1) sort by x asc, y desc
        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(b[1], a[1]);
        });

        int n = points.length;
        int ans = 0;

        // 2) sweep
        for (int i = 0; i < n; i++) {
            int yi = points[i][1];
            int maxY = Integer.MIN_VALUE; // best y seen so far to the right (and counted)
            for (int j = i + 1; j < n; j++) {
                int yj = points[j][1];
                // i must be upper-left of j  => yi >= yj (since x is already increasing)
                if (yi >= yj && yj > maxY) {
                    ans++;
                    maxY = yj; // ensures no third point lies in/ on the rectangle
                }
            }
        }
        return ans;
    }
}
