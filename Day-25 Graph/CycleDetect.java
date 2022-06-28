import java.util.*;

class Node{
    int first, second;
    Node(int f, int s){
        first = f;
        second = s;
    }
}

public class Solution {
    
    public static String cycleDetection(int[][] edges, int vertex, int m) {
        // Write your code here.
        int vis[] = new int[vertex + 1];//visited array to check if node visited earlier
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(); //Creating adjaceny list
        for(int i = 0; i <= vertex; i++){
            ArrayList<Integer> arr = new ArrayList<Integer>();
            adj.add(arr);
        } // adding the lists for every vertex 1 based indexing
        for(int i = 0; i < edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            ArrayList<Integer> temp = adj.get(a);
            temp.add(b);
             ArrayList<Integer> temp2 = adj.get(b);
            temp2.add(a);
            
        }// Taking the pairs from edges matrix and creating the adjacency list
        Queue<Node> q = new LinkedList<Node>();
        Node temp = new Node(1 , -1);
        q.add(temp); //Added the first node vertex = 1 to the queue with no parent so = -1
        vis[1] = 1;
        for(int i =0; i <= vertex; i++){
            if(vis[i] == 0){
                Node temp3 = new Node(i, -1);
                q.add(temp3);
                vis[i] = 1;
            } // for different component adding to queue with parent = -1
            while(!q.isEmpty()){
                Node node = q.poll();
                int n = node.first;
                int par = node.second;
                for(Integer it: adj.get(n)){
                    if(vis[it] == 0){
                        Node temp2 = new Node(it, n);
                        q.add(temp2);
                        vis[it] = 1;
                    }
                    else if(vis[it] == 1 && it != par)
                        return "Yes"; //if cycle exists we return yes
                }
            }
        }
        
        
        return "No";  // if whole code runs without a return of yes than cycle didn't exist so we return no.
    
        
        
        
        
        
    }
    
}