/************************************************************

    Following is the TreeNode class structure:

    class BinaryTreeNode {
		int val;
		BinaryTreeNode left;
		BinaryTreeNode right;

		BinaryTreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

************************************************************/
import java.util.*;
class Pair {
    BinaryTreeNode node;
    int line;
    Pair(BinaryTreeNode node, int line) {
        this.node = node;
        this.line = line;
    }
}
public class Solution {
    public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
        // Write your code here.
        ArrayList<Integer> ans = new ArrayList<>(); 
        if(root == null) {
            return ans;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root, 0)); 
        while(!q.isEmpty()) {
            Pair it = q.remove();
            int line = it.line; 
            BinaryTreeNode temp = it.node; 
            if(map.get(line) == null) map.put(line, temp.val); 
            if(temp.left != null) {
                q.add(new Pair(temp.left, line - 1)); 
            }
            if(temp.right != null) {
                q.add(new Pair(temp.right, line + 1)); 
            }
        }
    
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            ans.add(entry.getValue()); 
        }
        return ans; 
    }
}
