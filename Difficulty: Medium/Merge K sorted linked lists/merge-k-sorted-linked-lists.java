/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    Node mergeKLists(Node[] arr) {
        // code here
        
        Node head = new Node(-1);
        Node temp = head;
        PriorityQueue<Node> heap = new PriorityQueue<>((a, b) -> a.data - b.data);
        
        for(Node node : arr) heap.add(node);
        
        while(!heap.isEmpty())
        {
            Node currNode = heap.poll();
            Node nextNode = currNode.next;
            temp.next = currNode;
            temp = temp.next;
            
            if(nextNode != null) heap.add(nextNode);
            
        }
        
        return head.next;
        
    }
}