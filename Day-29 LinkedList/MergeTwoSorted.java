import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the linked list node structure:
    
    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

************************************************************/


public class Solution {
    public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
        if(first==null)return second;
        if(second==null)return first;
        if(first.data>second.data){
           LinkedListNode<Integer> temp=first;
            first=second;
            second= temp;
        }
        // iteration
        LinkedListNode<Integer>res=first;
        while(first!=null && second!=null){
            LinkedListNode<Integer>tmp=null;
            while(first!=null && first.data<=second.data){
                tmp=first;
                first=first.next;
            }
            tmp.next=second;
            
            LinkedListNode<Integer>temp=first;
            first=second;
            second=temp;
        }
        return res;
    }
}