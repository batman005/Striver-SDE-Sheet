import java.util.*;
public class Solution {
	public static int minSubsetSumDifference(int[] arr, int n) {
		// Write your code here.
        if(n == 1)
            return arr[0];
        int totalSum = 0;
        for(int num: arr)
              totalSum += num;
        int[][] dp = new int [n][totalSum + 1];
        for(int row [] : dp)
            Arrays.fill(row, -1);
        for(int i = totalSum; i>= 0; i--)
            target(n - 1, i, arr,dp);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= totalSum; i++){
            boolean val = dp[n -1][i] == 0 ? false: true;
            if(val == true){
                int diff = Math.abs(i - (totalSum - i));
                min = Math.min(diff,min);
            }
        }
        return min;
	}
        private static boolean target(int n, int k, int[] arr, int[][] dp) {
        
        if(k == 0)
            return true;
        
        if(n==0)
            return arr[n]==k;
        
        if(dp[n][k] != -1)
            return dp[n][k]==0?false:true;
        
        boolean consider = false;
        if(arr[n] <= k)
            consider = target(n-1, k-arr[n], arr, dp);
        boolean notConsider = target(n-1, k, arr, dp);
        dp[n][k] = consider || notConsider?1:0;
        return consider || notConsider;
    }
}
    
