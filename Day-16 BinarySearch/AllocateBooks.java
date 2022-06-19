import java.lang.Math;
public class Solution {
    public static long ayushGivesNinjatest(int n, int m, int[] time) 
    {
        // n = number of days or number of partitions we have to make
        //m = number of chapters or size of the array
        
        //finding range where possible ans lies , range = [s,e]
        long start = 0;
        long end = 0;
        for(int i=0 ; i<m ; i++)
        {
            end = end + time[i];
            if(time[i]>start)
            {
                start = time[i];
            }
        }
        long ans = end;
        while(start <= end)
        {
            long mid = start + (end-start)/2;
            long sum = 0; //sum of split array
            int count = 1; // number of split arrays
            for(int i = 0; i<m ; i++)
            {
                if(sum + time[i] <= mid)          
                {
                    sum = sum + time[i];
                }
                else 
                {
                    count++;
                    sum = time[i];
                    
                }
            }
            if(count<=n) //n is number of splits we have to make
            {
                end = mid-1;
                //as we have to find minimum largest
                ans = Math.min(ans,mid); 
            }
            else //count > n
            {
                start = mid+1;
            }
        }
        return ans;
    }
}