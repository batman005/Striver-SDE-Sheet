// iterative method
public class Solution {
	
	public static int[] nextGreater(int[] arr, int n) {	
		//Write Your code here
        
        int[] ans = new int[n];
        ans[n - 1] = -1; // to handle last element
        
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                if(arr[i] < arr[j]){
                    ans[i] = arr[j];
                    break;
                }
                else{
                    ans[i] = -1;
                }
            }
        }
        return ans;
		
	}

}
// Stack
import java.util.Stack;
public class Solution {
	
	public static int[] nextGreater(int[] arr, int n) {	
		//Write Your code here
          Stack<Integer> st = new Stack<>();
          int[] ans = new int[n];
        
        for(int i = n - 1; i >= 0; i--){
            if(st.isEmpty())
                ans[i] = -1;
            else if(st.peek() > arr[i])
                ans[i] = st.peek();
            else{
                while(!st.isEmpty() && st.peek() <= arr[i])
                    st.pop();
                if(st.isEmpty())
                    ans[i] = -1;
                else
                    ans[i] = st.peek();
            }
            st.push(arr[i]);
        }
		return ans;
	}

}

