import java.util.ArrayList;

public class Solution 
{
    public static int uniqueElement(ArrayList<Integer> arr) 
    {
        //    Write your code here.
         int low = 0;
         int n = arr.size();
         int high = n - 2;
        while(low <= high ){
                 int mid = (low + high) >> 1;
                   if(mid%2 == 0){
                       if(arr.get(mid) != arr.get(mid+1)){
                           high = mid - 1;
                       } else {
                           low = mid + 1;
                       }
                              
                   }else {
                       if(arr.get(mid) == arr.get(mid+1)){
                           high = mid - 1;
                       } else {
                           low = mid + 1;
                       }
                           
                   }
        
        }
        return arr.get(low);
    }
}