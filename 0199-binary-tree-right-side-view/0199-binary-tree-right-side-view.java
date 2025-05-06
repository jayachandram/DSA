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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
        return new ArrayList<>();
        
    List<Integer> ans = new ArrayList<>();
    
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    
    while(!queue.isEmpty())
    {
        int level_size = queue.size();
        
        for(int i = 0; i < level_size; i++)
        {
            TreeNode node = queue.remove();
            
            if(i == level_size - 1)
                ans.add(node.val);
        
            if(node.left != null)
                queue.add(node.left);
                
            if(node.right != null)
                queue.add(node.right);
        } 
    }    
    return ans;
    }
}