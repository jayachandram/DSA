class Solution {
    public int maxOnes(int arr[], int k) {
        // code here
        
        int i = 0, zeros = 0, ans = 0;
        for(int j = 0; j < arr.length; j++)
        {
            if(arr[j] == 0)
            {
                zeros++;
            }
            
            while(zeros > k)
            {
               
                if(arr[i] == 0) zeros--;
                 i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}