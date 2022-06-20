//withstack
import java.util.* ;
public class Solution {
    public static List < Integer > getInOrderTraversal(TreeNode root) {
        // Write your code here.
        List<Integer> ans=new ArrayList<Integer>() ;
        Stack<TreeNode> stack=new Stack<>() ;
        TreeNode newNode=root ;
        while(true){
            if(newNode!=null){
                stack.push(newNode) ;
                newNode=newNode.left ;
            }
            else{
                if(stack.isEmpty()) break ;
                else{
                    newNode=stack.pop() ;
                    ans.add(newNode.data) ;
                    newNode=newNode.right ;
                }
            }
        }
        return ans ;
    }
    
}




//inorder traversal without stack

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
    public static void inorder(TreeNode root, List<Integer> ans)
    {
        if (root == null) {
            return;
        }
        inorder(root.left, ans);
        ans.add(root.data);
        inorder(root.right, ans);
    }
    
    public static List < Integer > getInOrderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        inorder(root, ans);        
        return ans;
    }
}