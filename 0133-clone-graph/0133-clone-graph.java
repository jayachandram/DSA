/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
       HashMap<Node, Node> map = new HashMap<>();

        return dfs(map, node);
        
    }
    private Node dfs(HashMap<Node, Node> map, Node node)
    {
        if(map.containsKey(node))
            return map.get(node);
        
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        
        for(Node i : node.neighbors)
        {
            newNode.neighbors.add(dfs(map, i));
        }
        return newNode;
    }
}