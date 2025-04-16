class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        long count = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[100001]; // assuming nums[i] <= 10^5
            int pairs = 0;

            for (int j = i; j < n; j++) {
                freq[nums[j]]++;
                if (freq[nums[j]] >= 2) {
                    // if freq is 2, one pair; if 3, two more pairs; if 4, three more, etc.
                    pairs += freq[nums[j]] - 1;
                }

                if (pairs >= k) {
                    count++;
                }
            }
        }

        return count;
    }
}
