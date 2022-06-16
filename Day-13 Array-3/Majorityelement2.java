import java.util.ArrayList;

 

public class Solution  

{

   public static ArrayList<Integer> majorityElementII(ArrayList<Integer> nums)  

   {

       ArrayList<Integer> res= new ArrayList<>();

       int ele1=-1,ele2=-1,cou1=0,cou2=0;

       for(int i:nums){

           if(ele1==i) cou1++;

           else if(ele2==i)cou2++;

           else if(cou1==0) {

               ele1=i;

               cou1++;

           }

           else if(cou2==0) {

               ele2=i;

               cou2++;

           }

           else{

               cou1--;

               cou2--;

           }

       }

       cou1=0;

       cou2=0;

       for(int i:nums){

           if(i==ele1) cou1++;

           else if(i==ele2) cou2++;

       }

       if(cou1>nums.size()/3) res.add(ele1);

       if(cou2>nums.size()/3) res.add(ele2);

       return res;

   }

}