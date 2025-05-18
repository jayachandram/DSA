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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        if(root == null)
            return new ArrayList<>();
        int level = 0;
        List<List<Integer>> ans = new ArrayList<>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            ArrayList<Integer> current_level = new ArrayList<>();
            
            int size = queue.size();
            
            for(int i = 0; i < size; i++)
            {
                if(queue.peek().left != null)
                    queue.add(queue.peek().left);
                
                if(queue.peek().right != null)
                    queue.add(queue.peek().right);
                    
                current_level.add(queue.poll().val);
            }
            
            if(level % 2 == 0)
                ans.add(current_level);
            else
            {
               Collections.reverse(current_level);
               ans.add(current_level);
            }   
            level++;
        }
        return ans;
    }
}