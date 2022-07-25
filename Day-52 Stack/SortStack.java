//recursive
import java.util.*;
public class Solution {

	public static void sortStack(Stack<Integer> stack) {
		// Write your code here.
        if(!stack.isEmpty()){
            int x = stack.pop();
            sortStack(stack);
            insert(x, stack);
        }
	}
    
    public static void insert(int x, Stack<Integer> stack){
        if(stack.size() == 0 || stack.peek() < x){
            stack.push(x);
        }
        else{
            int a = stack.pop();
            insert(x, stack);
            stack.push(a);
        }
    }

}
//iterative
import java.util.*;
public class Solution {

	public static void sortStack(Stack<Integer> stack) {
        if(!stack.empty())
        {   
		// Write your code here.
         Stack<Integer> temp=new Stack<>();
        while(!stack.empty())
        {
            int greater;
            if(temp.empty() || stack.peek()<=temp.peek())
            {
                temp.push(stack.peek());
                stack.pop();
//                System.out.println("1st temp:"+temp);
//                System.out.println("1st stack:"+stack);
            }
            else
            {
                greater=stack.peek();
                stack.pop();
                while(!temp.empty())
                {
                    if(temp.peek()>=greater)
                    {
                        stack.push(greater);
                        while (!temp.empty())
                        {stack.push(temp.peek());
                        temp.pop();}
//                        System.out.println("if temp:"+temp);
//                        System.out.println("if stack:"+stack);
                    }
                    else
                    {
                        stack.push(temp.peek());
                        temp.pop();
//                        System.out.println("else temp:"+temp);
//                        System.out.println("else stack:"+stack);
                    }
                }
                if(greater>stack.peek())
                    stack.push(greater);
            }
        }
        while (!temp.empty())
        {
            stack.push(temp.peek());
            temp.pop();
        }
        }
	}

}