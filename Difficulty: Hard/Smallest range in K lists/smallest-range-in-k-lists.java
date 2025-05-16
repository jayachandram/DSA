//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class DriverClass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[][] = new int[k][n];
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++) arr[i][j] = sc.nextInt();
            }
            ArrayList<Integer> range = new Solution().findSmallestRange(arr);
            System.out.println(range.get(0) + " " + range.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Solution {
    public ArrayList<Integer> findSmallestRange(int[][] arr) {
        int k = arr.length;
        int n = arr[0].length;

        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<ArrayList<Integer>> min_heap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.get(0), b.get(0))
        );

        int right = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            int val = arr[i][0];
            right = Math.max(right, val);
            min_heap.add(new ArrayList<>(Arrays.asList(val, i, 0))); // value, list index, element index
        }

        int left = min_heap.peek().get(0);
        ans.add(left);
        ans.add(right);

        while (true) {
            ArrayList<Integer> curr = min_heap.poll();

            int curr_val = curr.get(0);
            int curr_list = curr.get(1);
            int curr_index = curr.get(2);

            // Break if end of one list is reached
            if (curr_index + 1 == arr[curr_list].length)
                break;

            // Push next element from same list
            int next_val = arr[curr_list][curr_index + 1];
            min_heap.add(new ArrayList<>(Arrays.asList(next_val, curr_list, curr_index + 1)));

            // Update right if necessary
            right = Math.max(right, next_val);

            // Update left (min value in heap)
            left = min_heap.peek().get(0);

            // Update answer if this range is smaller
            if (right - left < ans.get(1) - ans.get(0)) {
                ans.set(0, left);
                ans.set(1, right);
            }
        }

        return ans;
    }
}


