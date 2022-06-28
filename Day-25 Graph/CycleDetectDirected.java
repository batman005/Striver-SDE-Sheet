//DFS
import java.util.ArrayList;
public class Solution {
  public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
    // Write your code here.
      ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
      for(int i = 0; i <= n; i++){
          ArrayList<Integer> arr = new ArrayList<Integer>();
          adj.add(arr);
         }
      for(int i=0; i<edges.size(); i++){
          ArrayList<Integer> temp = edges.get(i);
          int a = temp.get(0);
          int b = temp.get(1);
          ArrayList<Integer> temp2 = adj.get(a);
          temp2.add(b);
      }
      int vis[] = new int[n+1];
      int dfsvis[] = new int[n+1];
      for(int i = 1; i <= n; i++){
          if(vis[i] == 0){
              if(dfs(vis, dfsvis, adj, i) == true) return true;
          }
      }
      
      return false;
   }
    static boolean dfs(int []vis,int []dfsvis,ArrayList<ArrayList<Integer>> adj,int i){
        vis[i]=1;
        dfsvis[i]=1;
        for(Integer it: adj.get(i)){
            if(vis[it]==0){
                if(dfs(vis,dfsvis,adj,it)==true)
                    return true;
            }
            else if(dfsvis[it]==1)
                return true;
        }
        dfsvis[i]=0;
        return false;
    }
}
