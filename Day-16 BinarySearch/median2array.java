public class Solution {
    public static double median(int[] a, int[] b) {
        int len1 = a.length;
        int len2 = b.length;
        
        if(len1 > len2) return median(b, a);
        
        int positiveInfinity = Integer.MAX_VALUE;
        int negativeInfinity = Integer.MIN_VALUE;
        
        
        int left = -1, right = len1 - 1;
        int len = len1 + len2;
        int half = len /2;
        while (true) {
               int mid = (left+right) / 2;
               int rem = half - mid - 2;
            
            int aLeft = mid  >= 0 ? a[mid] : negativeInfinity;
            int aRight = mid+1 < len1 ? a[mid + 1]: positiveInfinity;
           int bLeft = rem  >= 0 ? b[rem] : negativeInfinity;
            int bRight = rem+1 < len2 ? b[rem + 1]: positiveInfinity;
            
            
            if(aLeft <= bRight && bLeft <= aRight){
                 if(len %  2 == 1){
                     return Math.min(aRight, bRight);
                 }
                 
                return (double) (Math.min(aRight, bRight) + Math.max(aLeft, bLeft)) /2;
            }
               
            if(aLeft > bRight){
                 right = mid - 1;
             } else{
                 left = mid + 1;
             }
        
        }
    }
}