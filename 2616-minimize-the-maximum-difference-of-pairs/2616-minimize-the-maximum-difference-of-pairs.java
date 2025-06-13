class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;

        int left = 0, right = nums[n - 1] - nums[0], ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canFormPairs(nums, p, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    // Greedy: Try to form max #pairs with diff <= mid
    private boolean canFormPairs(int[] nums, int p, int maxDiff) {
        int count = 0;
        int i = 1;
        while (i < nums.length) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                count++;
                i += 2; // skip the used pair
            } else {
                i++;
            }
        }
        return count >= p;
    }
}
