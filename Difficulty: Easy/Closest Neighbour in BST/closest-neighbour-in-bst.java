/*
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
} */
class Solution {
    public int findMaxFork(Node root, int k) {
        // code here.
        int[] ans = new int[1];
        ans[0] = -1;
        f(root, k, ans);
        return ans[0];
    }
    private void f(Node node, int k, int[] ans)
    {
        if(node == null) return;
        
        if(node.data <= k) 
            ans[0] = node.data;
            
        if(node.data < k && node.right != null)
            f(node.right,  k, ans);
            
        else if(node.data > k && node.left != null)
            f(node.left, k, ans);
    }
}