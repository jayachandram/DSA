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
    public Node swapKth(Node head, int k) {
        // code here
        int n = 0;
        Node temp = head;
        
        while(temp != null)
        {
            n++;
            temp = temp.next;
        }
        if(n < k) return head;
        int i = 1;
        
        Node first =  null;
        Node last = null;
        temp = head;
        
        while(temp != null)
        {
            if(i == k) first = temp;
            if(n - i == k - 1) last = temp;
            
            i++;
            temp = temp.next;
        }
            
        int data = first.data;
        
        first.data = last.data;
        last.data = data;
        
        return head;
        
    }
}
