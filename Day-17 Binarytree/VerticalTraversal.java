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
    static class Triplet{
        int x;
        int y;
        int val;
        Triplet(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
        // override
    }
   
    public static void dfs(List<Triplet> set, int x, int y, TreeNode root){
        if (root ==null) return;
        set.add(new Triplet(x, y, (int)root.data));
        if (root.left != null) dfs(set, x-1, y+1, root.left);
        if (root.right != null) dfs(set, x+1, y+1, root.right);
    } 
    public static ArrayList<Integer> verticalOrderTraversal(TreeNode<Integer> root) 
    {
        List<Triplet> set = new ArrayList<Triplet>();
        dfs(set, 0, 0, root);
        Collections.sort(set, (o1,o2)->{
            if(o1.x != o2.x) return o1.x-o2.x;
            else return o1.y-o2.y;
        });
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        int prev_x;
        while (i < set.size()){
            ans.add(set.get(i).val);
            prev_x = set.get(i++).x;
            while(i<set.size() && set.get(i).x == prev_x){
                ans.add(set.get(i++).val);
            }
        }
        return ans;  
    }
}
