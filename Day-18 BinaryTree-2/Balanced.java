/*************************************************************

Following is the Binary Tree node structure

class BinaryTreeNode<T> 
{
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    BinaryTreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
};

*************************************************************/

public class Solution {

	public static boolean isBalancedBT(BinaryTreeNode<Integer> root) {
		// Write your code here.
        return dfsHeight(root) != -1;
	}
    public static int dfsHeight (BinaryTreeNode<Integer> root) {
        if(root == null) return 0;
        
        int leftHeight = dfsHeight(root.left);
        if(leftHeight == - 1) return -1;
        int rightHeight = dfsHeight(root.right);
        if(rightHeight == -1 ) return -1;
        if(Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return Math.max(leftHeight, rightHeight) + 1;
        
    }
}
