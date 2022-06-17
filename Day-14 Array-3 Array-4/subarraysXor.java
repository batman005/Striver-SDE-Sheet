//prefix xor and hashMap
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	public static int subarraysXor(ArrayList<Integer> arr, int x) {
		// Write your code here.
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        int n = arr.size();
        int count = 0;
        int cpx = 0;
        for(int i = 0; i < n ; i++){
            cpx ^= arr.get(i);
            if(map.get(cpx^x)!= null)
                count += map.get(cpx^x);
            if(cpx == x)
                count++;
            if(map.get(cpx) != null)
                map.put(cpx,map.get(cpx) + 1);
            else
                map.put(cpx,1);
        }
        return count;
	}
}


//brute force
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;



public class Solution {
    public static int subarraysXor(ArrayList<Integer> arr, int x) {
        int n = arr.size();
        int count =0;
        for(int i=0;i<n;i++){
            int cur_xor = 0;
            for(int j=i;j<n;j++){
                cur_xor ^= arr.get(j);
                if(cur_xor == x)
                    count++;
            }
        }
        return count;
    }
}
