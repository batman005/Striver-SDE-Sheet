/*************************************************************
    Following is the Binary Tree node structure

	class TreeNode<T> {
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

*************************************************************/

import java.util.*;

public class Solution {
public static ArrayList<Integer> predecessorSuccessor(BinaryTreeNode<Integer> root, int key) {
 int pred = -1;
       int succ = -1;
       //Find the node which has the key value
       while(root != null){
           if(root.data == key)
               break;
           if(root.data > key){
               succ = root.data;    //If there is no right subtree to new root in next line, then previous root is the successor.
               root = root.left;
           }
           else{
               pred = root.data;
               root = root.right;
           }
       }
       BinaryTreeNode<Integer> predecessor = root.left;
       BinaryTreeNode<Integer> successor = root.right;
       //If there is a left subtree, predecessor will be the rightmost element in left subtree.
       if(predecessor != null){
           pred = predecessor.data;
           while(predecessor.right != null){
               predecessor = predecessor.right;
               pred = predecessor.data;
           }
       }
       //If there is a right subtree, successor will be the leftmost element in right subtree.
       if(successor != null){
           succ = successor.data;
           while(successor.left != null){
               successor = successor.left;
               succ = successor.data;
           }
       }
       ArrayList<Integer> ans = new ArrayList<>();
       ans.add(pred);
       ans.add(succ);
       return ans;
}
}