import java.util.*;


public class Solution {
    static boolean findTargetInMatrix(ArrayList<ArrayList<Integer>> mat, int m, int n, int target) {
        // Write your code here.
         for(int i = 0; i < m; i++){
             if(mat.get(i).get(n - 1) < target)
                 continue;
             else{
                 for(int j = 0; j < n ; j++){
                     if(mat.get(i).get(j) == target)
                         return true;
                 }
             }
         }
        return false;
    }
}