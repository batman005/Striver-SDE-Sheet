/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution 
{
    int  maxSum= 0;//Global Sum 
    class pair
    {
        boolean isBST;//Wheater the node is BST or not 
        int max;//BST Upperlimit
        int min;//BST Lower Limit 
        int sum;//Cumulative node sum in BST 
        pair()
        {
            this.isBST= true;
            this.max= Integer.MIN_VALUE;
            this.min= Integer.MAX_VALUE;
            this.sum= 0;
        }
    }
   
    public  pair isBST( TreeNode root )
    {//Post Order Bottom Up Approach 
        if ( root == null ){//base case when we hit the null node, we consider it as BST 
            pair p= new pair();
            return p;
        }
        
        pair left= isBST( root.left );//Recursing down the left subtree 
        pair right= isBST(  root.right );//Recursing down the right subtree 
        
        pair p= new pair();//Current node, after having its child information 
        
        if (  left.isBST == false || right.isBST == false ){//if the child is not BST the the node is also not a BST 
            p.isBST= false;
            return p;
        }
        
        //calculating the maximum and minimum value of the node, to serve it to the current node's parent //Sice child is BST Confirmed, we are calculating this way 
        p.max= Math.max( root.val, right.max );
        p.min= Math.min( root.val, left.min  );
        
        
        if ( root.val > left.max && root.val < right.min ){//checking that the current node is a Tree BST ( node BST is a Subset of TreeBST, hence its covered using Tree BST) or not
            p.sum= left.sum+ right.sum+ root.val;//calculating the sum, on the basis of sum received from the children//Cumulative BST Sum
            maxSum= Math.max( maxSum, p.sum );//if maximum sum found updating 
            return p;//returning the current node with information to the parent, to decide whether parent is BST or Not and including it will maximize the cumulating BST Sum or Not //current Node is BST  
        }
        
        //Not a Tree BST Case 
        p.isBST= false;//If the current node is not a BST 
        return p;//returning the current node ( not a BST ) with all the information to its parent
    }
    public int maxSumBST( TreeNode root ) {
        isBST( root );
        return maxSum;//Maximum BST Nodes Sum 
    }
}