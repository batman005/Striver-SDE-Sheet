import java.util.*;
public class Solution {

    static int kthLargest(ArrayList<Integer> arr, int size, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new CustomComparator());
        for(int i =0;i<size;i++)
            pq.offer(arr.get(i));
        int f = k-1;
        while(f>0){
            pq.remove();
            f--;
        }
        return pq.peek();
    }
}

class CustomComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer a, Integer b) {
        if(a>b)
            return -1;
        else if (a<b)
            return 1;
        else 
            return -1;
    }
}