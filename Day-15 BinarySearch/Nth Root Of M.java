public class Solution {
    public static double findNthRootOfM(int n, long m) {
    	// Write your code here.
        double power = 1.000000/n;
        double answer = Math.pow(m,power);
        return answer;
    }
}