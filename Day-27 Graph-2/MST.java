// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution
{
//Space : O(V*E) Time : O(V*E)
   static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
   {
       int[] parent = new int[V];
       int[] distance = new int[V];
       Arrays.fill(distance, Integer.MAX_VALUE);
       boolean[] isMst = new boolean[V];
       
       Map<Integer, PriorityQueue<int[]>> graph = new HashMap<>();
       int lowestWeightNode = fillGraph(graph, adj, V);
       distance[lowestWeightNode] = 0;
       parent[lowestWeightNode] = lowestWeightNode;
       isMst[lowestWeightNode] = true;
       
       PriorityQueue<int[]> edges = new PriorityQueue<>((ob1, ob2) -> Integer.compare(ob1[2], ob2[2]));
       int[] minCostEdge = graph.get(lowestWeightNode).remove();
       int u = minCostEdge[0];
       int v = minCostEdge[1];
       int w = minCostEdge[2];
       parent[v] = u;
       isMst[v] = true;
       distance[v] = w;
       
       edges.addAll(graph.get(lowestWeightNode));
       edges.addAll(graph.get(v));
       
       graph.remove(lowestWeightNode);
       graph.remove(v);
       
       while(!edges.isEmpty()){
           minCostEdge = edges.remove();
           u = minCostEdge[0];
           v = minCostEdge[1];
           w = minCostEdge[2];
           if(!isMst[v]){
               parent[v] = u;
               isMst[v] = true;
               distance[v] = w;
               edges.addAll(graph.get(v));
               graph.remove(v);
           }
       }
       
       int totalDistance = 0;
       for(int dist : distance){
           totalDistance += dist;
       }
       
       return totalDistance;
       
   }
   
   private static int fillGraph(Map<Integer, PriorityQueue<int[]>> graph,
                               ArrayList<ArrayList<ArrayList<Integer>>> adj,
                               int V){
                                   
       int smallestWeight = Integer.MAX_VALUE;
       int smallestWeightNode = 0;
       for(int i = 0; i < V; i++){
           graph.put(i, new PriorityQueue<int[]>((ob1, ob2) -> Integer.compare(ob1[2], ob2[2])));
       }
       
       for(int i = 0; i < adj.size(); i++){
           int u = i;
           for(List<Integer> edges : adj.get(i)){
               int v = edges.get(0);
               int w = edges.get(1);
               if(smallestWeight > w){
                   smallestWeight = w;
                   smallestWeightNode = u;
               }
               graph.get(u).add(new int[]{u, v, w});
           }
           
       }
       
       return smallestWeightNode;
                                   
   }

}