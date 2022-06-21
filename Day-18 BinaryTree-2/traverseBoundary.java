/************************************************************

    Following is the Binary Tree node structure:
    
   class TreeNode {
	    int data;
	    TreeNode left;
	    TreeNode right;

	    TreeNode(int data) {
		    this.data = data;
		    this.left = null;
		    this.right = null;
	    }

    }

************************************************************/
import java.util.*;

public class Solution {
    public static ArrayList<Integer> traverseBoundary(TreeNode root){
        ArrayList<Integer> ans = new ArrayList();
        if(isLeaf(root) == false) ans.add(root.data);
        addLeftBoundary(root, ans);
        addLeaves(root, ans);
        addRightBoundary(root, ans);
        return ans;
    }
    public static boolean isLeaf(TreeNode node){
        return (node.left == null) && (node.right == null);
    }
    public static void addLeftBoundary(TreeNode node, ArrayList<Integer> ans){
        TreeNode curr = node.left;
        while(curr != null){
            if(isLeaf(curr) == false) ans.add(curr.data);
            if(curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }
    public static void addRightBoundary(TreeNode node, ArrayList<Integer> ans){
        Stack<TreeNode> st = new Stack();
        TreeNode curr = node.right;
        while(curr != null){
            if(isLeaf(curr) == false) st.push(curr);
            if(curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        while(!st.isEmpty()){
            ans.add(st.pop().data);
        }
    }
    public static void addLeaves(TreeNode node, ArrayList<Integer> ans){
        if(isLeaf(node) == true){
            ans.add(node.data);
            return;
        }
        if(node.left != null) addLeaves(node.left, ans);
        if(node.right != null) addLeaves(node.right, ans);
    }
}