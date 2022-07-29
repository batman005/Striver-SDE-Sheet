import java.util.*;
public class Solution {
	public static int matrixMultiplication(int[] arr , int N) {
		// Write your code here
        int dp[][] = new int[N-1][N-1];
        for(int rw[]: dp)
           Arrays.fill(rw, -1);
        return mchain(1, N-1, arr,dp);
	}
    
    public static int mchain(int i, int j, int arr[],int dp[][]){
        if(i >= j)
            return 0;
        if(dp[i][j -1] != -1)
              return dp[i][j-1];
        int min = Integer.MAX_VALUE;
        for(int k = i; k < j; k++){
          int steps = (arr[i - 1]* arr[k] * arr[j]) + mchain(i,k,arr,dp)+ mchain(k+1, j, arr,dp);
            min = Math.min(min, steps);
        }
        dp[i][j-1] = min;
        return dp[i][j-1];
        }
}
