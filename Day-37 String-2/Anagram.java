import java.util.Arrays;
public class Solution {
    public static boolean areAnagram(String str1, String str2){
        // Write your code here.
        char charArray1[] = str1.toCharArray();
        char charArray2[] = str2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        if(charArray1.length == charArray2.length)
        {
            for(int i =0; i <str1.length(); i++){
                if(charArray1[i] != charArray2[i])
                    return false;
            }
            return true;
        }
        else 
            return false;
           
    }
}