import java.util.* ;
import java.io.*; 
/****************************************************************
	
	Following is the structure of the Singly Linked List.
	
	class LinkedListNode<T> {
    	T data;
    	LinkedListNode<T> next;

    	public LinkedListNode(T data) {
        	this.data = data;
    	}
	}

****************************************************************/

public class Solution {
	public static LinkedListNode<Integer> removeKthNode(LinkedListNode<Integer> head, int K) {
		// Write your code here.
        LinkedListNode new_node = head;
        LinkedListNode p = head;
        
        int count = 0;
        if(new_node == null)
            return head;
        if(K == 0)
            return head;
        
        while(new_node != null){  //finding len
            count++;
            new_node = new_node.next;
        }
        //finding which element to delete
        int element_to_delete = count - K;
        if(element_to_delete == 0){ 
            head = head.next;
            return head;
        }
        //accsessing the previous element that we wants to delete
        new_node = head;
        for(int i = 0; i < element_to_delete - 1; i++){
            new_node = new_node.next;
        }
                           //deleting the element by changing the address
        new_node.next=new_node.next.next;
        //p.next=null;
        return head;
    
	}
}
