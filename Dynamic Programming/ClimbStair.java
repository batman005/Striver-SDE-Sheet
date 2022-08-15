import java.util.Arrays;
public class Solution {
	public static int countDistinctWayToClimbStair(long nStairs) {
		// Write your code here.
        int[] dp = new int[(int)nStairs + 1];
        Arrays.fill(dp, -1);
        int res = solve((int)nStairs, dp) %1000000007;
        return  res;
	}
    public static int solve(int n, int[] dp){
        if(n == 1 || n == 0)
            return 1;
        if(dp[n] != -1)
            return dp[n]%1000000007;
         return dp[n]=solve(n-2,dp)%1000000007+solve(n-1,dp)%1000000007;
    }
}