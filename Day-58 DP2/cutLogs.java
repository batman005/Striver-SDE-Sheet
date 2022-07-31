import java.util.*;
public class Solution {
    static int dp[][];
    public static int cutLogs(int k, int n) {
        //Write your code here
        dp = new int[101][10001];
        for(int[] arr: dp)
            Arrays.fill(arr,-1);
        return solve(k, n);
    }
    
    public static int solve(int e, int f){
        if(f == 1 || f == 0)
            return f;
        if(e == 1)
            return f;
        if(dp[e][f] != -1)
            return dp[e][f];
        int ans = Integer.MAX_VALUE;
        int l = 1;
        int h = f;
        while (l <= h){
            int mid = (l + h >>1);
            int go_below = solve(e - 1, mid - 1);
            int go_above = solve(e, f - mid);
            int temp = 1 + Math.max(go_above, go_below);
            if(go_above > go_below)
                l = mid + 1;
            else
                h = mid - 1;
            ans = Math.min(ans, temp);
        }
        return dp[e][f] = ans;
    }

}
