/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}  */
class Solution {
    public static int minTime(Node root, int target) {
        // code here
        HashMap<Node, Node> child_parent_map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Integer> visited = new HashMap<>();
        Node target_node = null;
        int min_time = 0;
        
        queue.add(root);
        while(!queue.isEmpty())
        {
            Node node = queue.remove();
            if(node.data == target) target_node = node;
            
            if(node.left != null)
            {
                child_parent_map.put(node.left, node);
                queue.add(node.left);
            }
            if(node.right != null)
            {
                child_parent_map.put(node.right, node);
                queue.add(node.right);
            }
            visited.put(node, 0);
        }
        
        queue.add(target_node);
        visited.put(target_node, 1);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            int bool = 0;
            for(int i = 0; i < size; i++)
            {
                Node node = queue.remove();
                
                if(node.left != null && visited.get(node.left) == 0)
                {
                    bool = 1;
                    visited.put(node.left, 1);
                    queue.add(node.left);
                }
                
                if(node.right != null && visited.get(node.right) == 0)
                {
                    bool = 1;
                    visited.put(node.right, 1);
                    queue.add(node.right);
                }
                
                if(child_parent_map.get(node) != null && visited.get(child_parent_map.get(node)) == 0)
                {
                    bool = 1;
                    visited.put(child_parent_map.get(node), 1);
                    queue.add(child_parent_map.get(node));
                }
            }
            if(bool == 1) min_time++;
        }
        return min_time;
        
    }
}