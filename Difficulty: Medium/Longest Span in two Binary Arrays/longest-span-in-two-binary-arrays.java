
class Solution {
    public int longestCommonSum(int[] a1, int[] a2) {
        // Code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum1 = 0, prefixSum2 = 0, maxLength = 0;
        
        for(int i = 0; i < a1.length; i++)
        {
            prefixSum1 += a1[i];
            prefixSum2 += a2[i];
            
            int diff = prefixSum1 - prefixSum2;
            
            if(diff == 0)
                maxLength = Math.max(maxLength, i + 1);
            else if(map.containsKey(diff))
                maxLength = Math.max(maxLength, i - map.get(diff));
            else
                map.put(diff, i);
        }
        return maxLength;
    }
}