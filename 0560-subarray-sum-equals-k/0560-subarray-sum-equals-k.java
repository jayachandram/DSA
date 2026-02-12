class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int prefixSum = 0, count = 0;

        for(int num : nums)
        {
            prefixSum += num;
            
            int remainingSum = prefixSum - k;
            count += map.getOrDefault(remainingSum, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        
        return count;
    }
}