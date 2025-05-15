//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();

            Solution ob = new Solution();
            int result = ob.countSubstring(s);

            System.out.println(result);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int countSubstring(String s) {
        // code here
        
        int[] arr = new int[26];
        int count = 0;
        
        int n = s.length();
        
        if(n == 1)
            return 1;
            
        for(int i = 0; i < n; i++)
            arr[s.charAt(i) - 'a'] += 1;
        
        for(int i = 0; i < 26; i++)
            count += (arr[i] * (arr[i] + 1)) / 2;

        return count;
    }
}