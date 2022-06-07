import java.util.* ;
import java.io.*; 
public class Solution {
    public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n) {
        // Write your code here.
        int count = 0;
        for(int i = m; i < m + n; i++){
             arr1[i] = arr2[count++];
        }
       Arrays.sort(arr1);
        return arr1;
    }
}
