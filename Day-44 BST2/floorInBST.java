/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T>
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

public class Solution {
    public static TreeNode<Integer> prev=null; 
    public static int floorInBST(TreeNode<Integer> root, int X) {
        //    Write your code here.
      
        if(root == null){
                return prev.data;
        }
        if(root.data == X){
            return X;
        }
        if(root.data < X){
            prev = root;
            return floorInBST(root.right, X);
        }
        else{
            return floorInBST(root.left, X);
        }
        
        
    }
}