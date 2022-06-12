// Permutation of String

import java.util.*;
public class Solution {
    public static List<String> findPermutations(String s) {
        // Write your code here.
        return helper("",s);
    }
    static List<String> helper(String p, String up) {
        if(up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        List<String> list = new ArrayList<>();
        for(int i = 0; i <= p.length(); i++) {
            String a = p.substring(0,i);
            String b = p.substring(i);
            list.addAll(helper(a+ch+b,up.substring(1)));
        }
        return list;
    }
}

//Permutation of Array


class Solution {
    private void recurPermute(int index,int[] nums, List<List<Integer>> ans){
        if(index == nums.length){
            List<Integer> ds = new ArrayList < > ();
            for (int i = 0; i < nums.length; i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList <> (ds));
            return;
        }
        
        for(int i = index; i < nums.length; i++){
            swap(i, index,nums);
            recurPermute(index + 1, nums, ans);
            swap(i, index, nums);
        }
    }
     
    private void swap(int i, int j, int[] nums){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
        
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recurPermute(0, nums, ans);
        return ans;
    }
}



