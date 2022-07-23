import java.util.*;
public class Solution {
	public static ArrayList<ArrayList<Integer>> pwset(ArrayList<Integer> arr) {
		// WRITE YOUR CODE HERE
        ArrayList<ArrayList<Integer>> finalList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        powerSubset(arr,0,finalList,list);
        return finalList;
	}
    
    
    private static void powerSubset(ArrayList<Integer> arr,int index, ArrayList<ArrayList<Integer>> finalList, ArrayList<Integer> list){
        if(index > arr.size())
            return;
       ArrayList<Integer> temp = new ArrayList<Integer>();
       if(index == arr.size()){
           temp.addAll(list);
           finalList.add(temp);
           return;
       }
        list.add(arr.get(index));
        powerSubset(arr,index+1,finalList,list);
        list.remove(list.size()-1);
        powerSubset(arr,index+1,finalList,list);
      
    }
}

