/*************************************************************

Following is the Binary Tree Node structure:

    class TreeNode<T> {
		public T data;
		public BinaryTreeNode<T> left;
		public BinaryTreeNode<T> right;

		TreeNode(T data) {
			this.data = data;
			left = null;
			right = null;
	  	}
    }

*************************************************************/

class Pair{

   int height;

   int diameter;

   public Pair(int height, int diameter){

       this.height = height;

       this.diameter = diameter;

   }

}
public class Solution {
	public static int diameterOfBinaryTree(TreeNode<Integer> root) {
		// Write your code here.
       Pair p = helper(root);
        return p.diameter;
	}
    
    public static Pair helper(TreeNode<Integer> root){
                if(root == null)
                {
                    Pair p = new Pair (0,0);
                    return p;
                }
        
                Pair lDH = helper(root.left);
                Pair rDH = helper(root.right);
        
                int h = 1 + Math.max(lDH.height, rDH.height);
        
                int currD = lDH.height + rDH.height;
                int d = Math.max(currD, Math.max(lDH.diameter,rDH.diameter));
        
        Pair p = new Pair(h,d);
        return p;
        }
}