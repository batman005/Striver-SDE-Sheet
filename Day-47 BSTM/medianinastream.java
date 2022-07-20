import java.util.*;

public class Solution {
    public static int[] findMedian(int[] arr, int n) {
        // Write your code here.
        Queue<Integer> minPQ = new PriorityQueue<Integer>();//creating priorityQueue.
        Queue<Integer> maxPQ = new PriorityQueue<Integer>(Collections.reverseOrder());
        ArrayList<Integer> medians = new ArrayList<>(); //creating arrayList
        
        for(int val: arr){
            if(maxPQ.isEmpty() || maxPQ.peek() >= val)
                maxPQ.offer(val);
            else 
                minPQ.offer(val);
            
            
            if(maxPQ.size() > minPQ.size() + 1)
                minPQ.offer(maxPQ.poll());
            
            else if(maxPQ.size() < minPQ.size())
                maxPQ.offer(minPQ.poll());
          if(maxPQ.size() == minPQ.size()) // conditions 3
                medians.add((maxPQ.peek() + minPQ.peek())/2);
            else
                medians.add(maxPQ.peek());
                
        }
        
        int answer[] = new int[medians.size()]; // creating the  array to return the answers 
        for(int i=0;i<medians.size();i++){
            answer[i] = medians.get(i); //fill up the aaray with values get from ArrayList
        }
        return answer;
        // return the Array
    }
}
