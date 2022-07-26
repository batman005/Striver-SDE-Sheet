import java.util.*;
public class Solution {

	public static int minTimeToRot(int[][] grid, int n, int m) {
		// Write your code here.
        int row = grid.length;
        int col = grid[0].length;
        
        Queue<Integer> q = new LinkedList<>();
        int freshOrange = 0;
        
        int rowMove[] = {1, 0, - 1, 0};
        int colMove[] = {0, 1, 0, -1};
        
        for(int i = 0; i < row; i++){
          for(int j = 0; j < col; j++){
              if(grid[i][j] == 2){
                  q.add(i * col + j);
              }
              else if(grid[i][j] == 1){
                  freshOrange++;
              }
          }
        }
        
        int time = 0;
        
        while(freshOrange != 0 && !q.isEmpty()){
            int qSize = q.size();
            time++;
            for(int i = 0; i < qSize; i++){
                int curr = q.poll();
                int r = curr/col;
                int c = curr%col;
                
                for(int k = 0; k < rowMove.length; k++){
                    int x = r + rowMove[k];
                    int y = c + colMove[k];
                    
                    if(x < 0 || y < 0 || x >= row || y >= col || grid[x][y]  != 1)
                        continue;
                    grid[x][y] = 2;
                    freshOrange--;
                    
                    if(freshOrange == 0){
                        break;
                    }
                    q.add(x*col+y);
                }
            }
            
        }
        return (freshOrange == 0)? time : -1;
	}

}