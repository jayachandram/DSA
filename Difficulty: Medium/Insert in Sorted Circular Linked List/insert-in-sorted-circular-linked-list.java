/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
} */

class Solution {
    public Node sortedInsert(Node head, int data) {
        // code here
        Node last = head;
        while(last.next != head)
            last  = last.next;
            
        Node node = new Node(data);
        Node first = head;
        Node prev = last;
        
        while(head.next != first)
        {
            if(head == first && head.data >= data)
            {
                node.next = first;
                last.next = node;
                return node;
                
            }
            if(head.data >= data)
            {
                prev.next = node;
                node.next = head;
                return first;
            }
            prev = head;
            head = head.next;
        }
        if(last.data <= data)
        {
            last.next = node;
            node.next = first;
            return first;
        }
        else
        {
            prev.next = node;
            node.next = last;
            return first;
        }
    }
}