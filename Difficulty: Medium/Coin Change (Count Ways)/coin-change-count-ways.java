//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String inputLine[] = read.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int sum = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.count(arr, sum));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int count(int coins[], int sum) {
        // code here.
        int[][] dp = new int[coins.length][sum + 1];
        
        return f(coins, sum, coins.length - 1, dp);
    }
    private int f(int[] coins, int sum, int idx, int[][] dp)
    {
        
        if(idx == 0)
            return sum % coins[idx] == 0 ? 1 : 0;
            
        if(dp[idx][sum] != 0)
            return dp[idx][sum];
            
        int notTake = 0, take = 0;
        
        notTake = f(coins, sum, idx - 1, dp);
        
        if(coins[idx] <= sum)
            take = f(coins, sum - coins[idx], idx, dp);
            
        return dp[idx][sum] = (notTake + take);    
    }
}