//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String digits = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.countWays(digits);
            out.println(ans);

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public int countWays(String digits) {
        // code here
        int[] dp = new int[digits.length()];
        Arrays.fill(dp, -1);
        
        return f(digits, 0, digits.length(), dp);
        
    }
    private int f(String digits, int index, int n, int[] dp)
    {
        if(index == n)
            return 1;
        
        if(digits.charAt(index) == '0')
            return 0;
        
        if(dp[index] != -1)
            return dp[index];
        
        int ways = f(digits, index + 1, n, dp);
        
        if(index < n-1)
        {
            int num = Integer.parseInt(digits.substring(index, index + 2));
            
            if(num >= 10 && num <= 26)
                ways += f(digits, index + 2, n, dp);
        }
        
        return dp[index] = ways;
        
    }
}