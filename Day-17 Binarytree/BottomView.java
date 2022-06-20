/*********************************************

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

*********************************************/


import java.util.*;
public class Solution {
    public static ArrayList<Integer> bottomView(BinaryTreeNode root) {
        Queue<Pair> q= new ArrayDeque<Pair>();
        Map<Integer,Integer> map=new TreeMap<>();
        ArrayList<Integer> l=new ArrayList<>();
        
        q.add(new Pair(0,root));
        if(root==null) return l;
        
        while(!q.isEmpty()){
            Pair cur=q.poll();
            
            map.put(cur.hd,cur.node.val);
            
            if(cur.node.left!=null){
                q.add(new Pair(cur.hd-1,cur.node.left));
            }
            if(cur.node.right!=null){
                q.add(new Pair(cur.hd+1,cur.node.right));
            }
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            l.add(entry.getValue());
        }
        return l;
    }
    static class Pair{
        int hd;
        BinaryTreeNode node;
        public Pair(int hd,BinaryTreeNode node){
            this.hd=hd;
            this.node=node;
        }
    }
}