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
    public int lengthOfLoop(Node head) {
        // code here
        Node slow = head, fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        
            if(fast == slow)
            {
                Node temp= slow.next;
                int cnt = 1;
                
                while(temp != slow)
                {
                    cnt++;
                    temp = temp.next;
                }
                return cnt;
            }    
        
        }
        return 0;
    }
}