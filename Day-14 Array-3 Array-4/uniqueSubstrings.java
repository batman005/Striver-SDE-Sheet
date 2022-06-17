import java.util.* ;
import java.io.*; 
public class Solution 
{
	public static int uniqueSubstrings(String input) 
    {
		//write your code here
        int maxLen = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<Character>();
        int left = 0;
        for(int right = 0; right < input.length(); right++){
            if(set.contains(input.charAt(right))){
                while(left<right & set.contains(input.charAt(right))){
                    set.remove(input.charAt(left));
                    left++;
                    }
                 }
            set.add(input.charAt(right));
            maxLen = Math.max(maxLen,right - left + 1);
        }
        return maxLen;
	}
}

import java.util.* ;
import java.io.*; 
public class Solution 
{
	public static int uniqueSubstrings(String s) 
    {
		int length = s.length();

    if (length < 2) {
      return length;
    }

    int result = 0;
    boolean[] count = new boolean[128];

    char c;
    for (int i = 0, j = 0; i < length; i++) {
      c = s.charAt(i);
      while (count[c]) {
        count[s.charAt(j++)] = false;
      }

      count[c] = true;
      result = Math.max(result, i - j + 1);
    }

    return result;
	}
}

