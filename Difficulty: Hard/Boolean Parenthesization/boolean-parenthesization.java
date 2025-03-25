//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.*;

class GFG {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            Solution obj = new Solution();
            System.out.println(obj.countWays(s));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static int countWays(String s) {
        int [][][] dp = new int [s.length()][s.length()][2];
        
         for (int[][] row : dp) {
            for (int[] cell : row) {
                cell[0] = cell[1] = -1;
            }
        }
        
        return f(0, s.length() - 1, s, 1, dp);
    }

    static int f(int i, int j, String s, int isTrue, int[][][] dp) {
        // Base case: invalid range
        if (i > j) return 0;

        // Base case: single character check
        if (i == j) {
            if (isTrue == 1) return s.charAt(i) == 'T' ? 1 : 0;
            else return s.charAt(i) == 'F' ? 1 : 0;
        }
        
        if(dp[i][j][isTrue] != -1)
            return dp[i][j][isTrue];
            
        int ways = 0;

        // Check every operator between i and j
        for (int k = i + 1; k <= j - 1; k += 2) {
            int leftTrue = f(i, k - 1, s, 1, dp);
            int leftFalse = f(i, k - 1, s, 0, dp);
            int rightTrue = f(k + 1, j, s, 1, dp);
            int rightFalse = f(k + 1, j, s, 0, dp);

            char operator = s.charAt(k);

            // Evaluate based on the current operator
            if (operator == '&') {
                if (isTrue == 1) ways += leftTrue * rightTrue;
                else ways += leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse;
            } 
            else if (operator == '|') {
                if (isTrue == 1) ways += leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue;
                else ways += leftFalse * rightFalse;
            } 
            else if (operator == '^') {
                if (isTrue == 1) ways += leftTrue * rightFalse + leftFalse * rightTrue;
                else ways += leftTrue * rightTrue + leftFalse * rightFalse;
            }
        }

        return dp[i][j][isTrue] = ways;
    }
}
