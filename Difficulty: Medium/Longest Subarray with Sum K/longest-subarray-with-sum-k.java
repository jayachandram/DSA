// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        
        int ans =  0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        for(int i = 0; i < arr.length; i++)
        {
            sum += arr[i];
            int remained = sum - k;
            
            if(map.containsKey(remained)) ans = Math.max(ans, i - map.get(remained));
            if(!map.containsKey(sum)) map.put(sum, i);
        }
        return ans;
    }
}
