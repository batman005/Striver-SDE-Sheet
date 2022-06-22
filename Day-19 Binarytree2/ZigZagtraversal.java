class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int level = 0;
        while(!q.isEmpty()){
            int qlen = q.size();
            List<Integer> t = new ArrayList<>();
            for(int i = 0; i < qlen; i++){
                root = q.poll();
                
                if(level %  2 == 0){
                    t.add(root.val);
                } else {
                    t.add(0, root.val);
                } 
                if (root.left != null)
                    q.add(root.left);
                if(root.right != null)
                    q.add(root.right);
            }
            level ++;
            res.add(t);
        }
        return res;
    }
}