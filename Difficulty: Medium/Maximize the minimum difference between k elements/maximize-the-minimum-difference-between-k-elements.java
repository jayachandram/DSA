class Solution {
    public int maxMinDiff(int[] arr, int k) {
        // code here
        Arrays.sort(arr);

        // define binary search range
        int low = 0;
        int high = arr[arr.length - 1] - arr[0];
        int answer = 0;

        // binary search to find max valid min-diff
        while (low <= high) {
            int mid = (low + high) / 2;

            if (isPossible(arr, k, mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // return the maximum feasible 
        // minimum difference
        return answer;
        
    }
    static boolean isPossible(int[] arr, int k, int mid) {
        int count = 1;
        int last = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - last >= mid) {
                count++;
                last = arr[i];
            }
            if (count == k)
                return true;
        }

        return false;
    }
}
