import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Node class:

    class LinkedListNode {
        int data;
        LinkedListNode next;
        
        public LinkedListNode(int data) {
            this.data = data;
        }
    }

*****************************************************************/


public class Solution {
    static LinkedListNode addTwoNumbers(LinkedListNode head1, LinkedListNode head2) {
        // Write your code here.
        LinkedListNode dummy = new LinkedListNode(-1);
        LinkedListNode temp = dummy;
        int carry = 0;
        while(head1! = null || head2! = null || carry==1){
            int total = 0;
            if(head1 != null){
                total += head1.data;
                head1 = head1.next;
            }
            if(head2 != null){
                total += head2.data;
                head2 = head2.next;
            }
            total += carry;
            carry = total/10;
            LinkedListNode node = new LinkedListNode(total % 10);
            temp.next = node;
            temp = temp.next;
        }
        return dummy.next;
    }
}