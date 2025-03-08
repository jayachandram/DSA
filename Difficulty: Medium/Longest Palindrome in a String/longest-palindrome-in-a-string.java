//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    static String longestPalindrome(String s) {
        // code here
        int  len = s.length();
        int start = 0, end = 0;
        int ans = 0;
        for(int i = 0; i < len; i++)
        {
            int left = i, right = i;
            while( left > -1 && right < len && s.charAt(left) == s.charAt(right))
            {
                //even length
                if(right - left + 1 > ans)
                {
                    start = left;
                    end = right;
                    ans = right - left + 1;
                }
                left--;
                right++;
            }
            //odd length
            left = i;
            right = i+1;
            while( left > -1 && right < len && s.charAt(left) == s.charAt(right))
            {
                if(right - left + 1 > ans)
                {
                    start = left;
                    end = right;
                    ans = right - left + 1;
                }
                left--;
                right++;
            }
        }
        StringBuilder str = new StringBuilder();
        
        for(int i = start; i <= end; i++)
            str.append(s.charAt(i));
            
        return str.toString();
    }
}