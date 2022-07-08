public class Solution {
    public static int romanToInt(String s) {
        // Write your code here
        int ret = 0;
        int temp = 0;
        
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            int pos = 0;
         switch(curr){
                case 'I': pos = 1; break;
                case 'V': pos = 5; break;
                case 'X': pos = 10; break;
                case 'L': pos = 50; break;
                case 'C': pos = 100; break;
                case 'D': pos = 500; break;
                case 'M': pos = 1000; break;
                default: return 0;   
            }
            
            ret+=pos;
            if(temp<pos)
            {
                ret -= temp*2;
            }
            
            temp=pos;
        }
        
        return ret;
    }
}