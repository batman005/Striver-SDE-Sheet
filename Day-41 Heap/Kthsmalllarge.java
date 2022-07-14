
import java.util.*;


public class Solution {
    public static ArrayList<Integer> kthSmallLarge(ArrayList<Integer> arr, int n, int k) {
        //Write your code here
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i :arr)
            pq.add(i);
        int kSmall=-1,kLarge=-1;
        for(int i=0;i<n;i++){
            int x=pq.remove();
            if(i==k-1){
              kSmall=x;
                
            }
            if(i==n-k){
                kLarge=x;
               
            }
            
        }
       ans.add(kSmall);
        ans.add(kLarge);
        
        return ans;
        
    }
}

//2nd method
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int n : nums) {
            minHeap.add(n);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        return minHeap.peek();
    }
}