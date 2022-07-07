public class Solution 
{
	public static String reverseString(String str) 
	{
		//Write your code here
        String[] s = str.split(" ");
        String ans = "";
        
        for(int i = s.length - 1; i >= 0; i--){
            if(!s[i].isEmpty()){
                ans += s[i];
                
                if(i != 0){
                    ans += " ";
                }
            }
        }
        return ans;
	}
}
