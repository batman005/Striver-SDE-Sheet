/************************************************************

    Following is the TreeNode class structure

    class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	   }
	}


************************************************************/
import java.io.*;
import java.util.*;

public class Solution {
    
    public static class Pair
    {
        TreeNode node;
        int height;
        
        Pair(TreeNode node, int height)
        {
            this.node = node;
            this.height = height;
        }
    }    
    
    public static int getMaxWidth(TreeNode root) {
        
        if(root == null)
            return 0;
        
        ArrayList<Pair> q = new ArrayList<>();
        q.add(new Pair(root, 0));
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int s = 0;
        
        int ans = Integer.MIN_VALUE;
        
        while(q.size()>0)
        {
            s = q.size();
            
            Pair front = q.get(0);
            
            map.put(front.height, s);
            
            // while completing first level
            while(s-- > 0)
            {
                Pair rm = q.remove(0);
                
                if(rm.node.left != null)
                    q.add(new Pair(rm.node.left,rm.height+1));
                if(rm.node.right != null)
                    q.add(new Pair(rm.node.right,rm.height+1));
                
            }
            
        }
        
//         System.out.println(map);
        
        for(int key: map.keySet())
        {
            ans = Math.max(ans, map.get(key));
        }
        return ans;
    }
}



