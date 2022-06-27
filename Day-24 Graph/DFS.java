import java.util.*;
// need to under this code
public class Solution {
   public static void f(int node,ArrayList<ArrayList<Integer>> map,ArrayList<Integer> storeDfs,boolean[] visited){
// storing the node and then marking as visited
       storeDfs.add(node);
       visited[node] = true;
//         System.out.println(node+" node");
//checking there are any adjacent nodes then i am going to apply dfs on that node
       for(Integer it:map.get(node)){
           if(!visited[it]){
               f(it,map,storeDfs,visited);
           }
       }
       
   }
   public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> map) {
       ArrayList<ArrayList<Integer>> ver=new ArrayList<>();
         for(int i=0;i<v;i++){
           ver.add(new ArrayList < > ());
       }
       for(int i=0;i<e;i++){
/* very important step the input given is in reference to egdes , and that edges are not syncing/ matching with index of arraylist
  so we need to make a adjancy list in which each index(0,1,2,3....) contain edges with index/node.
*/
           ver.get(map.get(i).get(0)).add(map.get(i).get(1));
           ver.get(map.get(i).get(1)).add(map.get(i).get(0));
       }
//         System.out.println(ver+" vvvvvvvvvvv"+map);
       boolean[] visited = new boolean[v+1];
       for(int i=0;i<v;i++) visited[i] = false;
       
       ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
       int count=0;
   
       
       for(int i=0;i<v;i++){
           
           
           if(!visited[i]){
               ArrayList<Integer> storeDfs = new ArrayList<>();
               count++;
               f(i,ver,storeDfs,visited);
               if(storeDfs.size()==0) continue;
               ans.add(storeDfs);
           }
           
       }
       
       return ans;
   }
   
   
}