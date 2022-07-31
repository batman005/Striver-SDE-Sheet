import java.util.Arrays;
public class Solution {
    public static int minSumPath(int[][] grid) {
    	// Write your code here.
        int row = grid.length, col = grid[0].length;
        int[][] dp = new int[row][col];
        for(int[] arr: dp)
            Arrays.fill(arr, -1);
        return mincost(0,0,grid,dp);
    }
    
    public static int mincost(int i, int j, int[][] grid, int[][] dp){
        int row = grid.length, col = grid[0].length;
        if(i == row - 1 && j == col - 1){
            return grid[i][j];
        }
        if(dp[i][j] != -1 )
            return dp[i][j];
        int d = Integer.MAX_VALUE, r = Integer.MAX_VALUE;
        if(i+1 < row){
            d = mincost(i+1, j, grid, dp);
        }
        if(j + 1 < col){
            r = mincost(i, j+1, grid, dp);
        }
        return dp[i][j] = grid[i][j] + Math.min(r,d);
    }
}