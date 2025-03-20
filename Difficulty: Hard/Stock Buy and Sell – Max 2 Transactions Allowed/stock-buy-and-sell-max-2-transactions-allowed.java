//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxProfit(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int maxProfit(int[] prices) {
        // code here
        int[][][] dp = new int[prices.length][2][2+1];
        return f(prices,1, prices.length, 0, dp, 2);
    }
    static int f(int[] prices, int buy, int n, int index, int[][][] dp, int k)
    {
        if(k == 0 || index == n)
            return 0;
        
        if(dp[index][buy][k] != 0)
            return dp[index][buy][k];

        int profit = 0;
        if(buy == 1)
        {
            profit = Math.max(-prices[index] + f(prices, 0, n, index + 1, dp, k) , f(prices, 1, n, index + 1, dp, k ));
        }
        else
        {
            profit = Math.max(prices[index] + f(prices, 1, n, index+1, dp, k-1), f(prices, 0, n, index +1, dp, k));
        }
        
        return dp[index][buy][k] = profit;
    }
}