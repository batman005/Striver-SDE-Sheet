public class Solution  

{

   public static String writeAsYouSpeak(int n)  

   {

       // Write your code here.

          if(n==1) return "1";

         //Recursion..

         String s = writeAsYouSpeak(n-1);

            StringBuilder res = new StringBuilder();

                  int counter=0;


               for(int i =0;i<s.length();i++){

                   counter++;

               if(i==s.length()-1 || s.charAt(i)!=s.charAt(i+1)){

                  res.append(counter).append(s.charAt(i));

                  counter=0;

                   } 
               }

                return res.toString();
   }
}