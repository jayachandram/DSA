/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
} */class Solution {
    public int sumOfLongRootToLeafPath(Node root) {
        int[] res = new int[2];
        dfs(root, 0, 0, res);
        return res[1];
    }

    private void dfs(Node node, int currLength, int currSum, int[] res) {
        if (node == null) return;

        currLength += 1;
        currSum += node.data;

        if (node.left == null && node.right == null) {
            if (currLength > res[0]) {
                res[0] = currLength;
                res[1] = currSum;
            } else if (currLength == res[0]) {
                res[1] = Math.max(res[1], currSum);
            }
            return;
        }

        dfs(node.left, currLength, currSum, res);
        dfs(node.right, currLength, currSum, res);
    }
}
