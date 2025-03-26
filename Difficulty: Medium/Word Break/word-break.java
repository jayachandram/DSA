//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String s = sc.nextLine();
            String line = sc.nextLine();
            String[] dictionary = line.split(" ");

            Solution obj = new Solution();
            if (obj.wordBreak(s, dictionary)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public boolean wordBreak(String s, String[] dictionary) {
        // code here
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return f(s, dictionary, 0, s.length(), dp);
    }
    private boolean f(String s, String[]  dict, int index, int n, int[] dp)
    {
        if(index >= n)
            return true;
        
        if(dp[index] != -1)
            return dp[index] == 1 ? true : false;

        for(int i = 0; i < dict.length; i++)

            if(index + dict[i].length() <= n && s.substring(index,(index + dict[i].length())).equals(dict[i]))

               if(f(s, dict, index + dict[i].length(), n, dp))
                {
                    dp[index] = 1;
                    return true;
                }
                    

        dp[index] = 0;
        return false;
    }
}