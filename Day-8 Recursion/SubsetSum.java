import java.util.*;

public class Solution {
    public static ArrayList<Integer> subsetSum(int num[]) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        func(num, 0, 0, arr, num.length-1);
        Collections.sort(arr);
        return arr;
    }
    public static void func(int num[], int index, int sum, ArrayList<Integer> arr, int N){
        if(index>N){
            arr.add(sum);
            return;
        }
        func(num, index+1, sum, arr, N);
        func(num, index+1, sum+num[index], arr, N);
        return;
    }

}