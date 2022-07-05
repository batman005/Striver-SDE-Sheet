import java.util.* ;
import java.io.*; 
/***********************************************
    Following is the class structure of the Node class:

    class Node {
        int data;
        Node next;

        Node(int x) {
            this.data = x;
            this.next = null;
        }
    }

************************************************/

public class Solution {
    public static Node rotate(Node head, int k) {
        // Write your code here.
        if(head == null || head.next == null || k == 0)
            return head;
        Node temp = head;
        int count  = 1;
        while(temp.next != null){
            temp = temp.next;
            count++;
        }
        
        k = k % count;
        k =  count - k;
        temp.next = head;
        while(k > 0){
            temp = temp.next;
            k--;
        }
        head = temp.next;
        temp.next = null;
        return head;
    }
}