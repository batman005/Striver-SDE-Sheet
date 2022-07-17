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

    public  static int findCeil(TreeNode<Integer> node, int x) {
           
        // Write your code here
           int prev = -1;
           while(node != null){
               if(node.data == x){
                   return node.data;
                   }
               else if(node.data > x){
                   prev = node.data;
                   node = node.left;
               }
               else if(node.data < x){
                   node = node.right;
               }
           }
        return prev;
    }
}
