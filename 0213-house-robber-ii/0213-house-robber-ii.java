class Solution {
    public int rob(int[] arr) {

        int cnt = 0;
        for(int i : arr)
                cnt += i;
                
        if(cnt == 0)
            return 0;

        if(arr.length == 1)
            return arr[0];

        int[] dp = new int[arr.length];
            int a = f(arr,0, arr.length-2, dp);
            
            for(int i = 0; i < arr.length; i++)
                dp[i] = 0;

            int b = f(arr,1 , arr.length - 1, dp);
            
            return Math.max(a, b);
        }
        private int f(int[] arr, int index, int n, int[] dp)
        {
            if(index > n)
                return 0;
                
            if(dp[index] != 0)
                return dp[index];
                
            return dp[index] = Math.max( arr[index] + f(arr, index + 2, n, dp), f(arr, index + 1, n, dp) );
    }
}
