class Solution {
    public int minEatingSpeed(int[] arr, int k) {

        int min = 1, max = Arrays.stream(arr).max().getAsInt();

        while (min <= max) {
            int mid = min + (max - min) / 2;

            long count = 0;
            for (int num : arr)
                count += (num + mid - 1) / mid; // ceiling division

            if (count <= k) max = mid - 1;
            else min = mid + 1;
        }

        return min;
    }
}
