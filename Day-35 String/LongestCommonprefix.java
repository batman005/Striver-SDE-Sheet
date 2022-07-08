//binarySearch
class Solution {
    public String longestCommonPrefix(String[] strs) {
       if (strs == null || strs.length == 0)
           return "";
        int minLen = Integer.MAX_VALUE;
        for(String str : strs)
            minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while(low <= high){
            int middle = (low + high) / 2;
            if(isCommonPrefix(strs, middle))
                low = middle + 1;
            else 
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }
    
    private boolean isCommonPrefix(String[] strs, int len){
        String str1 = strs[0].substring(0, len);
        for(int i = 1; i < strs.length; i++)
            if(!strs[i].startsWith(str1))
                return false;
            return true;
    }
}


//Horizontal Scanning
 public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) return "";
    String prefix = strs[0];
    for (int i = 1; i < strs.length; i++)
        while (strs[i].indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length() - 1);
            if (prefix.isEmpty()) return "";
        }        
    return prefix;
}