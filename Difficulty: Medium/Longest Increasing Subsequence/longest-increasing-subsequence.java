//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine())
                               .trim()
                               .split(" "); // Read the input for the current test case
            int arr[] = new int[str.length];
            // Convert input string into an integer array
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            // Call the solution method and print the result
            System.out.println(new Solution().lis(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static int lis(int arr[]) {
        if (arr.length == 0) return 0;
        
        int[] list = new int[arr.length];
        int len = 0;
        
        for (int i : arr) {
            int index = bs(list, len, i);
            list[index] = i;
            
            if (index == len) len++;
        }
        return len;
    }
    
    static int bs(int[] list, int size, int element) {
        int low = 0, high = size - 1;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            if (list[mid] >= element)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
}
