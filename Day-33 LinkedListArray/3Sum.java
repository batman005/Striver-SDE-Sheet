import java.util.* ;
import java.io.*; 
public class Solution {

	public static ArrayList<ArrayList<Integer>> findTriplets(int[] arr, int n, int K)  {

	    // Write your code here.
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);
        
        int l = 0, r = 0;
        for(int i = 0; i < arr.length; i++){
            l = i + 1;
            r = arr.length - 1;
            while(l < r){
                if(arr[i] + arr[l] + arr[r] == K){
                    list.add(new ArrayList<>(Arrays.asList(arr[i], arr[l], arr[r])));
                    int x = arr[l];
                    int y = arr[r];
                    
                    //skipping same element for L and r
                    
                    while(l < r && arr[l] == x) l++;
                    while(l <r && arr[r] == y) r--;
                } else if(arr[i]+arr[l]+arr[r] < K)
                    l++;
                else
                    r--;
            }
            //skipping same for i
            while(i + 1 < arr.length && arr[i] == arr[i + 1])
                i++;
        }
        return list;
	}
}
