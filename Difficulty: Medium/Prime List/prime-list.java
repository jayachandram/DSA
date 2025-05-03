//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    Node next;
    int val;

    public Node(int data) {
        val = data;
        next = null;
    }
}

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = Integer.parseInt(in.readLine());
        while (t-- > 0) {

            Node head, tail;
            String s[] = in.readLine().trim().split(" ");
            int num = Integer.parseInt(s[0]);
            head = new Node(num);
            tail = head;
            for (int i = 1; i < s.length; i++) {
                num = Integer.parseInt(s[i]);
                tail.next = new Node(num);
                tail = tail.next;
            }
            Solution ob = new Solution();
            Node temp = ob.primeList(head);
            while (temp != null) {
                out.print(temp.val + " ");
                temp = temp.next;
            }
            out.println();
            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*
class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}
*/

class Solution {
    Node primeList(Node head) {
        // code here
        Node node = head;
        
        while(node != null)
        {
            node.val = nearestPrime(node.val);
            node = node.next;
        }
        return head;
        
    }
    boolean isPrime(int num)
    {
        if(num <= 1)
            return false;
            
        if(num == 2)
            return true;
            
        if(num % 2 == 0)
            return false;
            
        for(int i = 3; i <= Math.sqrt(num); i = i+2)
            if(num % i == 0)
                return false;
                
        return true;
    }
    int nearestPrime(int num)
    {
        if(isPrime(num))
            return num;
            
        int left = num -1;
        int right = num + 1;
        
        while(true)
        {
            if(left < 2)
                break;
            if(isPrime(left))
                break;
            left -= 1;
        }
   
        
        while(true)
        {
            if(isPrime(right))
                break;
            right++;
        }
        
        if(left < 2)
            return right;
        
        if(num-left <= right-num)
            return left;
            
        else
            return right;
    }
}







