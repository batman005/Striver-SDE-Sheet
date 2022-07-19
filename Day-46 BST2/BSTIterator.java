/*
    Definition of Node class for reference

    class TreeNode<T> 
    {
        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }

*/
import java.util.*;
public class Solution {

    static class BSTIterator{
        Stack<TreeNode> stack;
        BSTIterator(TreeNode<Integer> root){
            // Write your code here
            stack = new Stack<>();
            TreeNode node = root;
            updateStack(node);
        }

        int next(){
            // Write your code here
            TreeNode<Integer> toRemove = stack.pop();
            updateStack(toRemove.right);
            return  toRemove.data;
        }

        boolean hasNext(){
            // Write your code here
            return !stack.isEmpty();
        }
       public void updateStack(TreeNode<Integer> node){
        while(node != null){
            stack.add(node);
            node = node.left;
        }
       }
    }
}

/*
    Your BSTIterator object will be instantiated and called as such:
    BSTIterator iterator = new BSTIterator(root);
    while(iterator.hasNext())
    {
       print(iterator.next()+" ");
    }
*/
