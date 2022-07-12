import java.util.*;
public class Solution
{
    public static int jobScheduling(int[][] jobs)
    {
        // Write your code here
        Arrays.sort(jobs, (a, b) -> b[1] - a[1]);
        int maxDeadline = 0;
        for(int i = 0; i < jobs.length; i++){
            maxDeadline = Math.max(maxDeadline, jobs[i][0]);
        }
        int[] jobArray = new int[maxDeadline + 1];
        for(int i = 1; i < jobArray.length; i++){
            jobArray[i] = -1;
        }
        int maxProfit = 0;
        for(int i = 0; i < jobs.length; i++){
            for(int j = jobs[i][0]; j > 0; j--){
                if(jobArray[j] == -1){
                    jobArray[j] = jobArray[j] + 1;
                    maxProfit += jobs[i][1];
                    break;
                }
            }
        }
        return maxProfit;
    }
}
