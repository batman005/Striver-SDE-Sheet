import java.util.* ;
import java.io.*; 
public class Solution {
    public static long getTrappedWater(long[] arr, int n) {
        // Write your code here.
        long[] left = new long[n];
        long[] right = new long[n];
        left[0] = arr[0];
        right[n - 1] = arr[n - 1];
        for(int i = 1; i < n; i++){
            if(left[i - 1] > arr[i])
                left[i] = left[i - 1];
            else left[i] = arr[i];
        }
        for(int i = n - 2; i >= 0; i--){
            if(right[i + 1] > arr[i])
                right[i] = right[i + 1];
            else right[i] = arr[i];
        }
        long water_trapped = 0;
        for(int i = 1; i < n - 1; i++){
            long min = Math.min(left[i], right[i]);
            water_trapped += min - arr[i];
        }
        return water_trapped;
    }
}
