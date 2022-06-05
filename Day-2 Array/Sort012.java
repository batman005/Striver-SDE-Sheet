import java.util.* ;
import java.io.*; 
public class Solution 
{
    public static void sort012(int[] arr)
    {
        //Write your code here
           int low = 0;
        int middle =  0;
        int high = arr.length-1;
        
        while(middle <= high){
            if(arr[middle] <1){
                swap(arr,low,middle);
                low++;
                middle++;
         }else if(arr[middle] >1){
                swap(arr,middle,high);
                high--;
            } else {
                middle++;
            }
        }
    }
    
    private static void swap(int arr[],int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}