

// User function Template for Java
class Solution {

    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int[] arr) {

        // Your code here
        int max = arr[0];
        int cmax = arr[0];
        for(int i = 1;i<arr.length;i++)
        {
            cmax +=arr[i];
            cmax = Math.max(arr[i],cmax);
            max = Math.max(cmax,max);
        }
        return max;
    }
}
