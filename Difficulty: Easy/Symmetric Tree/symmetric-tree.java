/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

*/
class Solution {
    public boolean isSymmetric(Node root) {
        // Code here
        
        return f(root.left, root.right);
        
    }
    private boolean f(Node node1, Node node2)
    {
        if(node1 == null && node2 == null) return true;
        
        else if(node1 == null || node2 == null || node1.data != node2.data) return false;
        
        return f(node1.left, node2.right ) && f(node1.right, node2.left);
    }
}