//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String str = br.readLine();

            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findSubString(String str) {
        // code here
        
        boolean[] alphabets = new boolean[26];
        int distinct = 0;
        
        for(char ch : str.toCharArray())
        {
            if(alphabets[ch - 'a'] == false)
            {
                alphabets[ch-'a'] = true;
                distinct++;
            }
        }
        
        int[] curr = new int[26];
        int curr_count = 0;
        int start = 0;
        int ans = Integer.MAX_VALUE;
        
        for(int end = 0; end < str.length(); end++)
        {
            curr[str.charAt(end) - 'a'] += 1;
            
            if(curr[str.charAt(end) - 'a'] == 1)
                curr_count++;
            
            
            while(curr_count == distinct)
            {
                ans = Math.min(ans, end - start + 1);
                curr[str.charAt(start) - 'a'] -= 1;
                
                if(curr[str.charAt(start) - 'a'] == 0)
                    curr_count--;
                
                start++;
            }
        }
        
        return ans;
    }
}