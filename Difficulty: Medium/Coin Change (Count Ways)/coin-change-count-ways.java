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
        
        for(int i = 0; i <= sum; i++)
            dp[0][i] = i % coins[0] == 0 ? 1 : 0;
            
        int notTake = 0, take = 0;
        
        for(int i = 1; i < coins.length; i++)
        {
            for(int j = 0; j <= sum; j++)
            {
                notTake = dp[i - 1][j];
                take = 0;
                
                if(coins[i] <= j)
                   take = dp[i][j - coins[i]];
                   
                dp[i][j] = take + notTake;
            }
        }
        return dp[coins.length - 1][sum];
    }
}