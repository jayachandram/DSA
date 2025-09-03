/*
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
*/

class Solution {
    public Node reverse(Node head) {
        // code here
    
        Node first = head;
        Node last = head;
        
        while(last.next !=null) last = last.next;
        
        while(first.next != null && last.prev != null)
        {
            int data = first.data;;
            first.data = last.data;
            last.data = data;
            
            if(first == last || first.next == last) break;
            
            first = first.next;
            last = last.prev;
        }
        
        return head;
    }
}
