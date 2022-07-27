/*
	This is signature of helper function 'knows'.
	You should not implement it, or speculate about its implementation.

	boolean knows(int A, int B); 
	Function 'knows(A, B)' will returns "true" if the person having
	id 'A' know the person having id 'B' in the party, "false" otherwise.
	Use it as Runner.knows(A, B);
*/
	
import java.util.Stack;
public class Solution {
	public static int findCelebrity(int n) {
        // Write your code here.
        Stack<Integer> s = new Stack<>();
        
        //Inserting all party members of Party in the stack order doesn't matter;
        for(int i = 0; i < n; i++){
            s.push(i);
        }
        
        //in while only the ideal Candidate of having Celebrity is Left in the Stack
        while(s.size() > 1){
            int a = s.peek();
            s.pop();
            int b = s.peek();
            s.pop();
            if(Runner.knows(a,b)){
                s.push(b);
            } else{
                s.push(a);
            }
            
        }
        int celebrity = s.peek();
     
        //Then verify the Ideal Candidate of being celebrity by two conditions
        //1. Celebrity doesn't know anyone
        //2. All members excepts celebrity himself knows celebrity
        
        int rowsZero = 0;
        boolean ZeroRows = false;
        
        for(int i=0; i<n; i++){
            if(Runner.knows(celebrity,i) == false){
                rowsZero++;
            }
        }
        if(rowsZero == n) ZeroRows = true;
        
        int colsOnes = 0;
        boolean OnesCols = false;
        
        for(int i=0; i<n; i++){
            if(Runner.knows(i,celebrity) == true){
                colsOnes++;
            }
        }
        
        if(colsOnes == n-1) OnesCols = true;
        
        //After verify return the desired candidate
        
        if(OnesCols && ZeroRows) return celebrity;
        return -1;
    }
}