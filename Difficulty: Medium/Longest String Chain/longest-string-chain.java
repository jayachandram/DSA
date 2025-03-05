//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] words = sc.nextLine().trim().split(" ");
            Solution obj = new Solution();
            int res = obj.longestStringChain(words);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int longestStringChain(String words[]) {
        // code here
        
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        
        Map<String, Integer> dp = new HashMap<>();
        int maxChain = 1;
        
        for(String word : words)
        {
            dp.put(word,1);
            
            for(int i = 0; i < word.length(); i++)
            {
                String preString = word.substring(0,i) + word.substring(i+1);
    
                if(dp.containsKey(preString))
                    dp.put(word, Math.max(dp.get(word), dp.get(preString) + 1));
                
                maxChain = Math.max(maxChain, dp.get(word));
            }
        }
        
        return maxChain;
        
    }
}