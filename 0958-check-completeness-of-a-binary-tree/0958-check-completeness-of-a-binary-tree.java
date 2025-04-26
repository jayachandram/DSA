/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        
        boolean flag = false;
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            TreeNode curr_node = queue.poll();
            
            if(curr_node.left != null)
            {
                if(flag || curr_node.val > curr_node.left.val)
                    return false;
                queue.add(curr_node.left);
            }
            else
                flag = true;
                
            if(curr_node.right != null)
            {
                if(flag || curr_node.val > curr_node.right.val)
                    return false;
                queue.add(curr_node.right);
            }
            else
                flag = true;
        }
        return true;
    }
}