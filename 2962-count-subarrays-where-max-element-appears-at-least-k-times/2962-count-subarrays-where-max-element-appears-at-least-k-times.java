class Solution {
    public long countSubarrays(int[] arr, int k) {

        int n = arr.length;
        int max = Arrays.stream(arr).max().getAsInt();
        int j = 0;
        int count = 0;
        long  ans = 0;
        for(int i = 0; i < n; i++)
        {
            if(arr[i] == max)
                count++;
            

            while(count >= k)
            {
                ans += n - i;

                if(arr[j] == max)
                    count--;
                
                j++;
            }

        }
        return ans;
    }
}