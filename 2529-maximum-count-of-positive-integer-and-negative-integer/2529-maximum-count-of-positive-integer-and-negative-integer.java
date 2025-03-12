class Solution {
    public int maximumCount(int[] nums) {
        int positives = 0;
        int negatives = 0;
        for(int i : nums)
        {
            if(i > 0)
                positives++;
            else if(i < 0)
                negatives++;
        }
        return Math.max(positives, negatives);
    }
}