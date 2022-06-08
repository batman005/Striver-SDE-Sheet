import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution{
    public static int findDuplicate(ArrayList<Integer> arr, int n){
        // pigeon hole binary search
         int len = n;
        int low = 1;
        int high = len - 1;
        while (low < high){
            int mid = low + (high - low)/2;
            int cnt = 0;
            for(int i = 0; i < len; i++){
                if(arr.get(i) <= mid){
                    cnt++;
                }
            }
            
            if(cnt <= mid){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        return low;

    }
}
