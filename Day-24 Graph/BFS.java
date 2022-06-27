import java.util.*;
public class Solution {
    public static ArrayList<Integer> BFS(int vertex, int edges[][]){
        ArrayList<Integer> bfsTraverse = new ArrayList<>();
        boolean vis[] = new boolean[vertex];
        ArrayList<TreeSet<Integer>> graph = new ArrayList<>();
        for(int i=0;i<vertex;i++){
            graph.add(new TreeSet<>());
        }
        for(int j=0;j<edges[0].length;j++){
            int u = edges[0][j];
            int v = edges[1][j];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        
        for(int i=0;i<vertex;i++){
            if(!vis[i]){
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                vis[i] = true;
                while(!queue.isEmpty()){
                    int node = queue.poll();
                    bfsTraverse.add(node);
                    for(int nbr: graph.get(node)){
                        if(!vis[nbr]){
                            vis[nbr] = true;
                            queue.offer(nbr);
                        }
                    }
                }       
            }
        }
     
        return bfsTraverse;
    }
}