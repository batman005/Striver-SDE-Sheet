import java.util.*;
public class Solution {

    public static int[] KMostFrequent(int n, int k, int[] arr){
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int it:arr){
            if(map.containsKey(it))
                map.replace(it,map.get(it)+1);
            else
                map.put(it,1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->map.get(a)-map.get(b));
        for(Map.Entry<Integer,Integer> entry :map.entrySet()){
            pq.offer(entry.getKey());
            if(pq.size()>k)
                pq.poll();
        }
        int res[] = new int[k];
        for(int i=0;i<k;i++){
           res[i] = pq.poll(); 
        }
        return res;
    }
}
