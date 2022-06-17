import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution 
{
    
    static int merge(ArrayList<Integer> nums, int low, int mid, int high) {
        int cnt = 0;
        int j = mid + 1; 
        for(int i = low;i<=mid;i++) {
            while(j<=high && nums.get(i) > (2 * (long) nums.get(j))) {
                j++;
            }
            cnt += (j - (mid+1));
        }
        
        ArrayList<Integer> temp = new ArrayList<>(); 
        int left = low, right = mid+1; 
        while(left <= mid && right<=high) {
            if(nums.get(left) <=nums.get(right)) {
                temp.add(nums.get(left++)); 
            }
            else {
                temp.add(nums.get(right++)); 
            }
        }
        
        while(left<=mid) {
            temp.add(nums.get(left++)); 
        }
        while(right<=high) {
            temp.add(nums.get(right++)); 
        }
        
        for(int i = low; i<=high;i++) {
            nums.set(i, temp.get(i - low)); 
        }
        return cnt; 
    }
    static int mergeSort(ArrayList<Integer> nums, int low, int high) {
        if(low>=high) return 0; 
        int mid = (low + high) / 2;
        int inv = mergeSort(nums, low, mid); 
        inv += mergeSort(nums, mid+1, high); 
        inv += merge(nums, low, mid, high); 
        return inv; 
    }

    public static int reversePairs(ArrayList<Integer> arr) 
    {
        return mergeSort(arr, 0, arr.size() - 1); 
    }
}