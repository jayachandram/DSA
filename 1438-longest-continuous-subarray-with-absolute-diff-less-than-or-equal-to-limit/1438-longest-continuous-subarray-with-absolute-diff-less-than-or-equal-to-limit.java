class Solution {
    public int longestSubarray(int[] arr, int x) {
        return _longestSubarray(arr, x);
    }

    private int _longestSubarray(int[] arr, int x) {
        int[] maxDq = new int[arr.length]; // Stores indices in decreasing order
        int[] minDq = new int[arr.length]; // Stores indices in increasing order
        int maxFront = 0, maxRear = -1;
        int minFront = 0, minRear = -1;
        int currentIndex = 0, maxLength = 0, startIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            // Maintain decreasing order for maxDq
            while (maxRear >= maxFront && arr[maxDq[maxRear]] <= arr[i])
                maxRear--;
            maxDq[++maxRear] = i;

            // Maintain increasing order for minDq
            while (minRear >= minFront && arr[minDq[minRear]] >= arr[i])
                minRear--;
            minDq[++minRear] = i;

            // Shrink window if difference exceeds limit
            while (arr[maxDq[maxFront]] - arr[minDq[minFront]] > x) {
                currentIndex++;

                if (maxDq[maxFront] < currentIndex)
                    maxFront++;

                if (minDq[minFront] < currentIndex)
                    minFront++;
            }

            if (i - currentIndex + 1 > maxLength) {
                maxLength = i - currentIndex + 1;
                startIndex = currentIndex;
            }
        }

        return maxLength;
    }
}
