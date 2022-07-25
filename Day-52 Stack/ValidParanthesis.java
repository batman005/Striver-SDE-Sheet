import java.util.Stack;

public class Solution {
    public static boolean isValidParenthesis(String str) {
        // Write your code here.
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c == '[' || c == '(' || c == '{'){
                stack.push(c);
            }
            else if (c == ')'){
                if(stack.empty())
                    return false;
                if(stack.peek() == '('){
                    stack.pop();
                } 
                else break;
            }
            else if (c == '}'){
                  if (stack.empty()) return false;
                if (stack.peek() == '{') {
                    stack.pop();
                }
                else break;
            }
                 else if (c == ']') {
                if (stack.empty()) return false;
                if (stack.peek() == '[') {
                    stack.pop();
                }
                else break;
            }
        }
        return stack.empty();
    }
}