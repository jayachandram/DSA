/*
class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}
*/

class Solution {
    public Node mergeSort(Node head) {
        // code here
        int n = 0;
        Node temp = head;
        
        while(temp != null)
        {
            n++;
            temp = temp.next;
        }
        int[] arr = new int[n];
        
        temp = head;
        int i = 0;
        while(temp != null)
        {
            arr[i] = temp.data;
            temp = temp.next;
            i++;
        }
        Arrays.sort(arr);
        //mergeSort(arr);
        
        temp = head;
        i = 0;
        
        while(temp != null)
        {
            temp.data = arr[i];
            i++;
            temp = temp.next;
        }
        
        return head;
    }
}