//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            
            

            Solution ob = new Solution();
            
            System.out.println(ob.lookandsay(n));
        
System.out.println("~");
}
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String lookandsay(int n) {
        //your code here
        
        if(n == 1)
            return "1";

        StringBuilder previous = new StringBuilder("1");

        for(int i = 1; i < n; i++)
        {
            StringBuilder current = new StringBuilder();
            char ch = previous.charAt(0);
            int count = 0;
            for(int j = 0; j < previous.length();j++)
            {
                if(ch == previous.charAt(j))
                {
                    count++;
                }
                else
                {
                    current.append(String.valueOf(count));
                    current.append(ch);
                    ch = previous.charAt(j);
                    count = 1;
                }
            }
            current.append(String.valueOf(count));
            current.append(ch);
            previous = current;
        }
        return previous.toString();
    }
}

