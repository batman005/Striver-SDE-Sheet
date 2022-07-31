/*************************************************************
    Following is the Binary Search Tree node structure

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
	public static int KthLargestNumber(TreeNode<Integer> root, int k) {
		// Write your code here.
        Stack<TreeNode> s = new Stack<>();
          
        while(true){
            while(root != null){
                s.push(root);
                root = root.right;
            }
            if(s.size() == 0 && k > 0)
                return -1;
            root = s.pop();
            
            if(--k == 0)
                return root.data;
            root = root.left;
        }
	}
}