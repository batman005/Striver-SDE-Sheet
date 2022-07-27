import java.util.ArrayList;
import java.util.Stack;
import javafx.util.Pair;
import java.util.*;
import java.io.*;
 public class Solution {
    public static ArrayList<Integer> findSpans(ArrayList<Integer> price) {
     ArrayList<Integer>v=new ArrayList<>();
        Stack<Pair<Integer,Integer>>st=new Stack<Pair<Integer,Integer>>();
         for(int i=0;i<price.size();i++)
         {
             if(st.isEmpty())
             {
                 v.add(-1);
             }
             else if(st.size()>0 && st.peek().getKey()>price.get(i))
             {
                 v.add(st.peek().getValue());
             }
             else if(st.size()>0 && st.peek().getKey()<=price.get(i))
             {
                 while(st.size()>0 && st.peek().getKey()<=price.get(i))
                 {
                     st.pop();
                 }
                 if(st.size()==0)
                 {
                     v.add(-1);
                     
                 }
                 else
                 {
                     v.add(st.peek().getValue());
                 }
             }
             st.push(new Pair<>(price.get(i),i));
                 
         }
        
        for(int i=0;i<v.size();i++)
        {
           v.set(i,i-v.get(i));
        }
        return v;
    }
}
    