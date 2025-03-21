//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            // calling method findMaxSum() of class solve
            System.out.println(new Solution().findMaxSum(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int findMaxSum(int arr[]) 
    {
        // code here
        int sum = 0;
        for(int i : arr)
            sum += i;
            
        int[] dp = new int[arr.length];
        
        return f(arr, 0 , 0, arr.length, dp);
    }
    
    private int f(int[] arr , int sum, int index, int n, int[] dp)
    {
        if(index >= n)
            return 0;
        
        
        if(dp[index] != 0)
            return dp[index];
        
        
        return dp[index] = Math.max((arr[index] + f(arr, sum , index+2, n, dp)), f(arr, sum, index+1, n,dp));
    }
}