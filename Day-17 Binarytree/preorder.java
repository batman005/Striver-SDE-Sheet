/*
	
	Following is the Binary Tree node structure:

	public class TreeNode {
	    int data;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.data = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	       this.data = val;
	        this.left = left;
	        this.right = right;
	    }
	}

*/
import java.util.*;
public class Solution {
    public static void preorder(TreeNode root , List<Integer> ans){
        if(root == null){
             return;
        }
        ans.add(root.data);
        preorder(root.left, ans);
        preorder(root.right, ans);
           
    }
    
    
    
    
    public static List < Integer > getPreOrderTraversal(TreeNode root) {
    	// Write your code here.
        List<Integer> ans = new ArrayList<Integer>();
        preorder(root, ans);
        return ans;
        
    }
}

//iterative approach

import java.util.* ;
public class Solution {
    public static List < Integer > getPreOrderTraversal(TreeNode root) {
    	// Write your code here.
        List<Integer> ans=new ArrayList<>() ;
        Stack<TreeNode> stack=new Stack<>() ;
        if(root==null) return ans ;
        stack.push(root) ;
        while(!stack.isEmpty()){
            root=stack.pop();
            ans.add(root.data) ;
            if(root.right!=null) stack.push(root.right) ;
            if(root.left!=null) stack.push(root.left) ;
           
        }
         return ans ;
    }
}