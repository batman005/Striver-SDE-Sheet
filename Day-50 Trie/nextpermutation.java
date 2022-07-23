import java.util.* ;
import java.io.*; 
import java.util.ArrayList;
import java.util.Collections;

public class Solution 
{   
   public static ArrayList<Integer> reverse(ArrayList<Integer> al, int i, int j){
       while(i<j){
           Collections.swap(al, i++, j--);
       }
       return al;
   }
    public static ArrayList<Integer> nextPermutation(ArrayList<Integer> al) 
    {
     
        int i = al.size()-2;
        while(i>=0 && al.get(i) >= al.get(i+1)){
            i--;
        }
        if(i>=0){
            int j= al.size()-1;
            while(al.get(j)<=al.get(i)){
                j--;
            }
            Collections.swap(al,i,j);
        }
        al=reverse(al, i+1 , al.size()-1);
        return al;
        
    }
}