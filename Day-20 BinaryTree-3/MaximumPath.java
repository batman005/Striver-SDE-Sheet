/************************************************************

    Following is the Tree node structure
	
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

public class Solution {
    static long res;
    static long count;
    public static void leaves(TreeNode root){
        if(root == null)
            return;
        leaves(root.left);
        leaves(root.right);
        if(root.left==null && root.right == null)
            count++;
    }
	public static long findMaxSumPath(TreeNode root) {
		// Write your code here.
        
        if(root == null)
            return -1;
        res = -1;
        count = 0;
        leaves(root);
        if(count == 0 || count == 1)
            return -1;
        findMaxSumPathHelper(root);
        return res;
	}
    
    public static long findMaxSumPathHelper(TreeNode root){
        
        if(root == null)
            return 0;
        long left = findMaxSumPathHelper(root.left);
        long right = findMaxSumPathHelper(root.right);
        
        long temp = Math.max(left,right)+root.data;
               temp = Math.max(left+right+root.data,temp);
        
        res = Math.max(temp,res);
        return Math.max(left, right)+root.data;
    }
}