import java.util.ArrayList;

public class Solution {
	public static int maximumProduct(ArrayList<Integer> arr, int n) {
		// Write your code here.
        int ans = Integer.MIN_VALUE;
        int prod = 1;
        for(int i = 0; i < arr.size(); i++){
            prod = prod*arr.get(i);
            ans = Math.max(ans,prod);
            if(prod == 0){
                prod = 1;
            }
        }
        prod = 1;
        for(int i = arr.size() -  1; i >= 0; i--){
            prod = prod * arr.get(i);
            ans = Math.max(ans,prod);
            if(prod == 0){
                prod = 1;
            }
        }
        return ans;
	}
}

//Kadane's algo
import java.util.ArrayList;

public class Solution {
	public static int maximumProduct(ArrayList<Integer> arr, int n) {
		// Write your code here.
        int max_prod = arr.get(0);
        int min_prod = arr.get(0);
        int max = arr.get(0);
        
        for(int i = 1; i < n; i++){
            int first = arr.get(i);
            int second = max_prod * first;
            int third  = min_prod * first;
            
            max_prod = Math.max(Math.max(first, second), third);
            min_prod = Math.min(Math.min(first, second), third);
            
            max = Math.max(max, max_prod);
        }
        return max;
	}
}