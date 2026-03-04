class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        // code here
        
        int curr_xor = 0, ans  = 0;
        
        int i = 0;
        for(int j = 0; j < arr.length; j++)
        {
            
            if(j - i + 1 > k)
            {
                ans = Math.max(ans, curr_xor);
                curr_xor = curr_xor ^ arr[i];
                i++;
            }
            curr_xor = curr_xor ^ arr[j];
        }
        ans = Math.max(ans, curr_xor);
        return ans;
    }
}
