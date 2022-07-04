import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the LinkedListNode class:
	
	class LinkedListNode<T> {
    	T data;
    	LinkedListNode<T> next;

    	public LinkedListNode(T data) {
        	this.data = data;
    	}
	}

*****************************************************************/

public class Solution {

    public static boolean isPalindrome(LinkedListNode<Integer> head) {
        if(head == null || head.next == null)return true;
        
        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;
        LinkedListNode<Integer> copy = null;
        
        while(fast != null && fast.next != null){
            copy = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        LinkedListNode<Integer> last = null;
        if(fast == null){
            last = reverse(slow);
            copy.next = null;
        }else{
            last = reverse(slow.next);
            slow.next = null;
        }
        
        while(last != null){
            if(!head.data.equals(last.data)){
                return false;
            }
            
            head = head.next;
            last = last.next;
        }
        
        return true;
        
        
    }
    static LinkedListNode reverse(LinkedListNode<Integer> head){
        if(head == null || head.next == null)return head;
        
        LinkedListNode<Integer> dummy = null;
        
        while(head != null){
            LinkedListNode<Integer> fw = head.next;
            head.next = dummy;
            dummy = head;
            head = fw;
        }
        
        return dummy;
    }
}