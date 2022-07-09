public class Solution {

	public static int zAlgorithm(String s, String p, int n, int m) {
		// Write your code here
       if(s.length() == 0 && p.length() == 0)
           return 0;
        
        if(p.length() == 0)
            return 0;
        
        int i = 0,j = 0, p1 = 0, p2 = 0,count, res = 0;
        for(i = 0; i <= s.length()-p.length(); i++){
            if(s.charAt(i) == p.charAt(j)){
                p1 = i;
                p2 = 0;
                count = 0;
                while(p1 < s.length() && p2 < p.length()){
                    if(s.charAt(p1) == p.charAt(p2)){
                        count++;
                        p1++;
                        p2++;
                    }
                    else {
                        break;
                    }
                }
                if(count == p.length()){
                    res++;
                }
            }
        }
        return res;
	}

}