//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maxXor(arr));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    public int maxXor(int[] arr) {
        TrieNode root = new TrieNode();

        // Insert all numbers into Trie
        for (int num : arr) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.children[bit] == null) {
                    node.children[bit] = new TrieNode();
                }
                node = node.children[bit];
            }
        }

        int maxXOR = 0;

        // Find maximum XOR for each number
        for (int num : arr) {
            TrieNode node = root;
            int currXOR = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                int toggleBit = bit ^ 1;
                if (node.children[toggleBit] != null) {
                    currXOR |= (1 << i);
                    node = node.children[toggleBit];
                } else {
                    node = node.children[bit];
                }
            }
            maxXOR = Math.max(maxXOR, currXOR);
        }

        return maxXOR;
    }
}
