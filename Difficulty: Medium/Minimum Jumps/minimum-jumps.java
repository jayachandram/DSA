//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            System.out.println(new Solution().minJumps(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int minJumps(int[] arr) {
       
        if (arr.length < 2) return 0;

       
        if (arr[0] == 0) return -1;

        int jumps = 0;
        int currentMax = 0, furthest = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            // Track the furthest position reachable from index i
            furthest = Math.max(furthest, i + arr[i]);

            // If we've reached the last index or beyond, count the jump and finish
            if (furthest >= arr.length - 1) return ++jumps;

            // When we hit the current max boundary, take a jump
            if (i == currentMax) {
                jumps++;
                currentMax = furthest;

                // Check if we're stuck (no progress after jumping)
                if (currentMax == i) return -1;
            }
        }

        return -1; // If we exit the loop without reaching the end
    }
}
