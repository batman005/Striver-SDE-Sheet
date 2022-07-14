import java.util.*;

public class Solution 
{
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		// Write your code here.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(ArrayList<Integer> arr: kArrays)
        {
            for(int ele: arr){
                pq.add(ele);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }
        return ans;
	}
}
