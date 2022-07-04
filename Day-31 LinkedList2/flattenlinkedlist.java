import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Node class:

        class Node
		{
		    public int data;
		    public Node next;

		    Node(int data)
		    {
		        this.data = data;
		        this.next = null;
		    }
		}

*****************************************************************/
public class Solution 
{
    public static Node firstNode(Node head) 
    {
        Node slow = head, fast = head;
        while(fast != null) {
            fast = fast.next;
            
            if(fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            
            if(slow == fast) {
                slow = head;
                
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}