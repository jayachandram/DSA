//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        return f(arr, sum,0,0);
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