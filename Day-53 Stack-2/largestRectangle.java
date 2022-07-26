import java.util.*;

public class Solution {
  public static int largestRectangle(ArrayList < Integer > heights) {
    // Write your code here.
      
      Stack<Integer> stack = new Stack<>();
      
      int[] left = new int[heights.size()];
      int res = -1;
      
      
      for(int right = 0; right < heights.size(); right++){
          int leftMost = right;
          
          while(!stack.empty() && heights.get(stack.peek()) > heights.get(right)){
              int index = stack.pop();
              int curHeight = heights.get(index);
              
              res = Math.max(res, curHeight * (right - left[index]));
              leftMost = left[index];
          }
          stack.push(right);
          left[right] = leftMost;
      }
      
      while(!stack.empty()){
          int index = stack.pop();
           res = Math.max(res, heights.get(index) * (heights.size() - left[index]));
        }
        
        return res;
  }
}