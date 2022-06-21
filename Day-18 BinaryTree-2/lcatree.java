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

public class Solution 
{
    public static int lowestCommonAncestor(TreeNode<Integer> root, int x, int y) 
    {
        //    Write your code here.
        if(root == null)
        {
            return -1;
        }
        if(root.data == x || root.data == y)
        {
            return root.data;
        }
        int leftans = lowestCommonAncestor(root.left,x,y);
         int rightans = lowestCommonAncestor(root.right,x,y);
        if(leftans == -1 && rightans != -1){
            return rightans;
        }
        else if(leftans != -1 && rightans == -1)
        {
            return leftans;
        }
        else if(leftans == -1 && rightans == -1)
        {
            return -1;
        }
        return root.data;
    }
}
