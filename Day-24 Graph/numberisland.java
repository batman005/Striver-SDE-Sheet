public class Solution 
{
    public static int getTotalIslands(int[][] mat) 
	{
        //Your code goes here
        int count = 0;
        for(int i = 0; i< mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 1){
                    count++;
                    dfs(mat,i,j);
                }
            }
        }
            
        return count;
    }
    public static void dfs(int[][] mat, int i, int j){
        int dirs[][] = {{-1,1}, {0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0}};
        for(int idx = 0; idx<8; idx++){
            int ii = i + dirs[idx][0];
            int jj = j + dirs[idx][1];
            if(ii < 0 || jj < 0 || ii >= mat.length || jj >= mat[0].length || mat[ii][jj] == 0){
                continue;
            }
           mat[ii][jj] = 0;
            dfs(mat,ii,jj);
        }
    }
}