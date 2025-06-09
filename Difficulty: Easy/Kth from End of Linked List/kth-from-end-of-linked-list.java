/* Structure of node
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
} */

class Solution {

    // Function to find the data of kth node from
    // the end of a linked list.
    int getKthFromLast(Node head, int k) {
        // Your code here

        int len = 1;
        Node temp = head;
        while(temp.next != null)
        {
            len++;
            temp = temp.next;
        }
        if(k > len) return -1;
        
        temp = head;
        int i = 0;
        Node prev = null;
        while(len - i != k && temp != null)
        {
            prev = temp;
            temp = temp.next;
            i++;
        }
        if(prev == null) return head.data;

        return prev.next.data;
    }
}