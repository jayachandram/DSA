//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution ob = new Solution();

            if (ob.equalPartition(arr))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static boolean equalPartition(int arr[]) {
        // code here
        int sum = 0;
        for(int i : arr)
            sum += i;
        if(sum % 2 != 0)
            return false;
        return f(arr, sum/2,0,0);
    }
    static boolean f(int arr[], int target, int currentSum, int index)
    {

        if(currentSum == target)
            return true;
            
        if(index > arr.length - 1 || currentSum > target)
        {
            return false;
        }

        return  f(arr, target, currentSum + arr[index], index+1) || f(arr, target, currentSum, index+1);
    }
}