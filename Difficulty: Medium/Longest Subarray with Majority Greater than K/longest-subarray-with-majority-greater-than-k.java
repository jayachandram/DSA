//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends

// User function Template for Java
class Solution {
    static int longestSubarray(int[] arr, int k) {
        // Code Here
        int n = arr.length;
        Map<Integer, Integer> prefIdx = new HashMap<>();
        int sum = 0, res = 0;

        // Traverse through all elements
        for (int i = 0; i < n; i++) {

            // Consider arr[i] <= k as -1 and arr[i] > k as +1
            sum += (arr[i] > k ? 1 : -1);

            // make an entry for sum if it is not present
            // in the hash map
            if (!prefIdx.containsKey(sum))
                prefIdx.put(sum, i);
        }
        
        // If all elements are smaller than k, return 0
        if (prefIdx.containsKey(-n))
            return 0;
      
        prefIdx.put(-n, n);

        // For each sum i, update prefIdx[i] with
        // min(prefIdx[-n], prefIdx[-n+1] .... pref[i])
        for (int i = -n + 1; i <= n; i++) {
            if (!prefIdx.containsKey(i))
                prefIdx.put(i, prefIdx.get(i - 1));
            else
                prefIdx.put(i, Math.min(prefIdx.get(i), 
                                        prefIdx.get(i - 1)));
        }

        // To find the longest subarray with sum > 0 ending at i,
        // we need left-most occurrence of s' such that s' < s.
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (arr[i] > k ? 1 : -1);
            if(sum > 0)
                res = i + 1;
            else 
            	res = Math.max(res, i - prefIdx.get(sum - 1));
        }

        return res;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            int n = tokens.length;
            int[] arr = new int[n];

            int i = 0;
            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                arr[i] = Integer.parseInt(token);
                i++;
            }

            int k = Integer.parseInt(br.readLine().trim());
            System.out.println(new Solution().longestSubarray(arr, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends