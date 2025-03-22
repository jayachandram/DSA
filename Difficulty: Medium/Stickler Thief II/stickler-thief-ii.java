//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int n = s.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int[] arr = IntArray.input(br);

            Solution obj = new Solution();
            int res = obj.maxValue(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    int maxValue(int[] arr) {
        // code here
        
        int[] dp = new int[arr.length];
        int a = f(arr,0, arr.length-2, dp);
        
        int[] dpp = new int[arr.length];
        int b = f(arr,1 , arr.length - 1, dpp);
        
        return Math.max(a, b);
    }
    private int f(int[] arr, int index, int n, int[] dp)
    {
        if(index > n)
            return 0;
            
        if(dp[index] != 0)
            return dp[index];
            
        return dp[index] = Math.max( arr[index] + f(arr, index + 2, n, dp), f(arr, index + 1, n, dp) );
    }
}
