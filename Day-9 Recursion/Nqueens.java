import java.util.*;

public class Solution {
    public static ArrayList<ArrayList<Integer>> solveNQueens(int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        int[][] board = new int[n][n];
        int[] col = new int[n];
        int[] upperDiagonal = new int[2*n-1];
        int[] lowerDiagonal = new int[2*n-1];
        NQueenhelper(0,n,board,ans,col,upperDiagonal,lowerDiagonal);
        return ans;
    }
    private static void NQueenhelper(int i,int n,int[][] board,ArrayList<ArrayList<Integer>> ans,int[] col,int[] upperDiagonal,int[] lowerDiagonal){
        if(i==n){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int[] k : board){
                for(int m = 0;m<k.length;m++)
                    temp.add(k[m]);
            }
            ans.add(temp);
            return;
        }
        for(int j=0;j<n;j++){
            if(col[j]==0 && upperDiagonal[i+j]==0 && lowerDiagonal[n-1+i-j]==0){
                board[i][j] = 1;
                col[j]=upperDiagonal[i+j]=lowerDiagonal[n-1+i-j]=1;
                NQueenhelper(i+1,n,board,ans,col,upperDiagonal,lowerDiagonal);
                board[i][j] = 0;
                col[j]=upperDiagonal[i+j]=lowerDiagonal[n-1+i-j]=0;
            }
        }
    }
}