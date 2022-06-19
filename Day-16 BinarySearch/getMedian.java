//Naive
import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
	public static int getMedian(ArrayList<ArrayList<Integer>> matrix)
	{
		// Write your code here.
        ArrayList<Integer> arr = new ArrayList<>();
        int ans;
        
        
        //add all elements of the matrix into arrayList
        
        for(int i = 0; i < matrix.size(); i++){
            for(int j = 0; j < matrix.get(i).size(); j++){
               arr.add(matrix.get(i).get(j));
            
            }
        
        }
        
        //sort the arrayList to get median
       Collections.sort(arr);
        return arr.get(arr.size()/2);
	}
}


//Binary Search

import java.util.ArrayList;

public class Solution
{
    public static int countSmaller(ArrayList<Integer>arr, int n){
        int low  = 0, high = arr.size() - 1;
        while(low <= high){
            int mid = (low + high)>>1;
            if(arr.get(mid) <= n)
                low = mid + 1;
            else 
                high = mid - 1;
        }
        return low;
    }
	public static int getMedian(ArrayList<ArrayList<Integer>> matrix)
	{
		// Write your code here.
        int low = 0, high = (int)1e9;
        int n = matrix.size();
        int m = matrix.get(0).size();
        
        while(low <= high){
            int mid = (low+high)>>1;
            int count = 0;
            for(int i = 0; i < n; i++){
                count += countSmaller(matrix.get(i),mid);
            }
            
            if(count <= (n*m) >> 1)
                low = mid + 1;
            else 
                high = mid - 1;
        }
        return low;
  
	}
}