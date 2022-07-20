public class Solution
{
    public static int directions[][] = {{-1,0}, {0, 1}, {1, 0},{0, -1}};
       
    public static void dfs(int image[][], int i, int j, int from, int newColor){
        int n=image.length,m=image[0].length;
        if(i<0 || i>=n || j<0 || j>=m || image[i][j]!=from) return;
        image[i][j] = -newColor;
        for(int dir[]: directions) dfs(image,i+dir[0],j+dir[1],from,newColor);
    }
    
    public static int[][] floodFill(int[][] image, int x, int y, int newColor)
    {
        // Write your code here
        int from  = image[x][y];
        dfs(image,x,y,from,newColor);
        for(int i = 0; i < image.length; i++ ){
            for(int j = 0; j < image[0].length; j++){
                if(image[i][j] ==-newColor)
                    image[i][j] = newColor;
            }
        }
        return image;
    }
}

