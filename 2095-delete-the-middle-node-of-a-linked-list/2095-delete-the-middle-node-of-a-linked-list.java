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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) return null;

        ListNode slow = head, fast = head, prev = null;

        while(fast != null && fast.next != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = prev.next.next;

        return head;

    }
}

// class Solution {
//     public ListNode deleteMiddle(ListNode head) {
//         ListNode temp = head;
//         int n = 0;
//         while(temp != null)
//         {
//             n++;
//             temp = temp.next;
//         }
//         if(n == 1) return null;
        
//         int middle = n / 2, i = 1;
//         temp = head;
//         while(i < middle)
//         {
//             i++;
//             temp = temp.next;
//         }
//         temp.next = temp.next.next;

//         return head;
//     }
// }