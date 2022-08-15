//Memo
import java.util.*;
public class Main{
static int solveUtil(int ind, int[] arr, int[] dp){
    if(ind<0)  return 0;
    if(ind==0) return arr[ind];
    if(dp[ind]!=-1) return dp[ind];
    int pick= arr[ind]+ solveUtil(ind-2, arr,dp);
    int nonPick = 0 + solveUtil(ind-1, arr, dp);
    
    return dp[ind]=Math.max(pick, nonPick);
}

static int solve(int n,int[] arr){
    int dp[]=new int[n];
    Arrays.fill(dp,-1);
    return solveUtil(n-1, arr, dp);
}


public static void main(String args[]) {

  int arr[]={2,1,4,9};
  int n=arr.length;
  System.out.println(solve(n,arr));
}
}
//TAbulation
import java.util.*;
class Sol{
static int solveUtil(int n, int[] arr, int[] dp){
    
    dp[0]= arr[0];
    
    for(int i=1 ;i<n; i++){
        int pick = arr[i];
        if(i>1)
            pick += dp[i-2];
        int nonPick = 0+ dp[i-1];
        
        dp[i]= Math.max(pick, nonPick);
    }
    
    
    return dp[n-1];
}

static int solve(int n, int[] arr){
    int dp[]=new int[n];
    Arrays.fill(dp,-1);
    return solveUtil(n, arr, dp);
}


public static void main(String args[]) {

  int arr[]={2,1,4,9};
  int n=arr.length;
  System.out.println(solve(n,arr));
}
}
//Space
import java.util.*;
class TUF{
static int solve(int n, int[] arr){
    
   int prev = arr[0];
    int prev2 =0;
    
    for(int i=1; i<n; i++){
        int pick = arr[i];
        if(i>1)
            pick += prev2;
        int nonPick = 0 + prev;
        
        int cur_i = Math.max(pick, nonPick);
        prev2 = prev;
        prev= cur_i;
        
    }
    return prev;
}
public static void main(String args[]) {

  int arr[]={2,1,4,9};
  int n=arr.length;
  System.out.println(solve(n,arr));
}
}