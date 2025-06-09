/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) return null;
        int len = 1;
        ListNode temp = head;
        while(temp.next != null)
        {
            len++;
            temp = temp.next;
        }

        temp = head;
        int i = 0;
        ListNode prev = null;
        while(len - i != n && temp != null)
        {
            prev = temp;
            temp = temp.next;
            i++;
        }
        if(prev == null) return head.next;

        prev.next = prev.next.next;

        return head;
    }
}