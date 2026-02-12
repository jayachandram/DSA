class Solution {

    public int maxMinHeight(int[] arr, int k, int w) {

        int n = arr.length;

        // Find minimum element
        int low = arr[0];
        for (int i = 1; i < n; i++) {
            low = Math.min(low, arr[i]);
        }

        int high = low + k;
        int answer = low;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canAchieve(arr, k, w, mid)) {
                answer = mid;
                low = mid + 1;     // try higher minimum
            } else {
                high = mid - 1;    // reduce target
            }
        }

        return answer;
    }

    private boolean canAchieve(int[] arr, int k, int w, int target) {

        int n = arr.length;
        long[] waterStart = new long[n];
        long daysUsed = 0;

        for (int i = 0; i < n; i++) {

            // Carry forward previous water effect
            if (i > 0) {
                waterStart[i] += waterStart[i - 1];
            }

            long currentHeight = arr[i] + waterStart[i];

            // Remove expired water effect
            if (i >= w) {
                currentHeight -= waterStart[i - w];
            }

            if (currentHeight < target) {

                long need = target - currentHeight;
                daysUsed += need;

                if (daysUsed > k) {
                    return false;
                }

                waterStart[i] += need;
            }
        }

        return true;
    }
}
