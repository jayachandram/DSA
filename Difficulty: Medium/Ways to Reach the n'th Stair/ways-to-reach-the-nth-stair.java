//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();

        while (t-- > 0) {

            // taking count of stairs
            int m = sc.nextInt();

            // creating an object of class DynamicProgramming
            Solution obj = new Solution();

            // calling method countWays() of class
            // DynamicProgramming
            System.out.println(obj.countWays(m));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int countWays(int n) {
        // your code here
        if(n == 1 || n == 0)
            return 1;
            
        int t1 = 1;
        int t2 = 1;
        int i = 2;
        while(i++ <= n)
        {
            int curr = t1 + t2;
            t2 = t1;
            t1 = curr;
        }
        return t1;
    }
}
