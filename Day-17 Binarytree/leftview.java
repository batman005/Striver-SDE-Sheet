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
import java.util.*;

public class Solution 
{
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 
    {
        //    Write your code here.
        if(root == null) {
            return new ArrayList<>();
        }
        
        ArrayList<Integer> leftView = new ArrayList<>();
        
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            leftView.add(q.peek().data);
            
            for(int i=0 ; i<size ; i++) {
                TreeNode<Integer> curr = q.poll();
                
                if(curr.left != null) {
                    q.offer(curr.left);
                }
                if(curr.right != null) {
                    q.offer(curr.right);
                }
            }
        }
        
        return leftView;
    }
}
