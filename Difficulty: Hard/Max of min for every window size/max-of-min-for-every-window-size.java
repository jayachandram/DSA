

class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;

        // Arrays to store indexes of previous and next smaller elements
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> s = new Stack<>();

        // Fill left[]: Previous smaller element indexes
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i])
                s.pop();
            left[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }

        s.clear();

        // Fill right[]: Next smaller element indexes
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i])
                s.pop();
            right[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }

        // Array to store result for every window length
        int[] ans = new int[n + 1]; // 1-based indexing for convenience

        // Traverse all elements to compute window sizes
        for (int i = 0; i < n; i++) {
            int len = right[i] - left[i] - 1;
            ans[len] = Math.max(ans[len], arr[i]);
        }

        // Fill remaining entries to maintain decreasing property
        for (int i = n - 1; i >= 1; i--)
            ans[i] = Math.max(ans[i], ans[i + 1]);

        // Convert result to ArrayList (1-based to 0-based)
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            res.add(ans[i]);

        return res;
    }
}
