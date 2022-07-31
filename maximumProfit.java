import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution{
    public static int maximumProfit(ArrayList<Integer> prices){
        // Write your code here.
          int maxProfit=0;

       int price=prices.get(prices.size()-1);

       for(int i=prices.size()-1; i>=0; i--){

           price=Math.max(price,prices.get(i));

           maxProfit=Math.max(maxProfit,price-prices.get(i));

       }

    return maxProfit;
    }
}