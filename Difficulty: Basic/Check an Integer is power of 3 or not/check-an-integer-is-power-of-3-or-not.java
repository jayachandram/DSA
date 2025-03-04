//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.isPowerof3(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static String isPowerof3(int n) {
        if (n < 1) return "No"; // Negative numbers & 0 are not powers of 3

        while (n % 3 == 0) {
            n /= 3;
        }
        return (n == 1) ? "Yes" : "No";
    }
}
