public class Solution {

    public static int maximumXor(int[] A) {
        
        // Write your Code here
        Trie trie = new Trie();
        for(int i = 0; i < A.length; i++)
            trie.insertNode(A[i]);
        
        int ans = 0;
        for(int i = 0; i < A.length; i++)
            ans = Math.max(ans, trie.getMax_Xor(A[i]));
        
        return ans;
    }
}

class Node {
    Node links[] = new Node[2];
    
    public boolean containsKey(int num){
        return (links[num] != null);
    }
    
    public Node get(int num){
        return links[num];
    }
    
    public void put (int num, Node node){
        links[num] = node;
    }
}


class Trie {
    private Node root;
    
    public Trie(){
        root = new Node();
    }
    
    public void insertNode(int num){
        Node node = root;
        for(int i = 31; i >= 0; i--){
            int bits = (num >> i)& 1;
            if(!node.containsKey(bits))
                node.put(bits,new Node());
            node = node.get(bits);
        }
    }
    
    
    public int getMax_Xor(int num){
        Node node = root;
        int maxSum = 0;
        for(int i = 31; i >= 0; i --){
            int bits = (num >> i)&1;
            if(node.containsKey(1 - bits)){
                maxSum = maxSum | (1 << i);
                node = node.get(1 - bits);
            } 
            else 
                node = node.get(bits);
         }
        return maxSum;
    }
}