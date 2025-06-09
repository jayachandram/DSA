/*
class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
}*/

class Solution {
    public boolean isDeadEnd(Node root) {
        // Code here.
        return f(root, 1, Integer.MAX_VALUE);
    }
    private boolean f(Node root, int min, int max)
    {
        if(root == null) return false;
        if(min == max) return true;
        return (f(root.left, min, root.data - 1) || f(root.right, root.data + 1, max));
    }
}