//User function Template for Java

/*
*   adj: vector of vectors which represents the graph
*   S: source vertex to start traversing graph with
*   V: number of vertices
*/
class Solution
{
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> adj, int S)
    {
        // Write your code here
        /*
          Algorithm
           1. Create Distance array Intialize it with Integer_MaxValue
        2.realx all the distance V - 1 times
        3. now repeat process one more time if there is updation in any vertex distance then there
        is negative cycle
        */
        int[] distance = new int[V];
        Arrays.fill(distance, 100000000);
        
        distance[S] = 0;
        
        for(int i=0; i< V; i++){
            for(ArrayList<Integer> list: adj){
                int u = list.get(0);
                int v = list.get(1);
                int w = list.get(2);
                
                if(distance[v] > distance[u] + w){
                    distance[v] = distance[u] + w;
                }
            }
        }
         return distance;
    }
}