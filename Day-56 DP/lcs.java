
public class Solution {

	public static int lcs(String s, String t) {
		//Your code goes here
        int n = s.length();
        int m = t.length();
        int dp[][] = new int[n][m];
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == t.charAt(0))
                dp[i][0] = 1;
        }
        for(int i = 1; i < m; i++){
            if(s.charAt(0) == t.charAt(i))
                dp[0][i] = 1;
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(s.charAt(i) == t.charAt(j)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n - 1][m - 1];
    }

}