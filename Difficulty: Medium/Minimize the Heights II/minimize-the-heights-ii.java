

// User function Template for Java

class Solution {
    int getMinDiff(int[] arr, int k) {
        int n =arr.length;
        if( n == 1)
        {
            return 0;
        }
        Arrays.sort(arr);
        int ans = arr[n-1] - arr[0];
        int min = arr[0] + k;
        int max = arr[n-1] - k;
        for(int i=0; i<n-1; i++){
            int min_ele = Math.min(min, arr[i+1]-k);
            int max_ele = Math.max(max, arr[i]+k);
                if(min_ele < 0)
                continue;
            ans = Math.min(ans, max_ele - min_ele);
        }
        return ans;
    }
}
