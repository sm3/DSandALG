import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BalancedBrackets {
    public static boolean isBalanced(String expression) {
        
    final Character LEFT_PAREN = '(';
	final Character RIGHT_PAREN = ')';
	final Character LEFT_BRACE = '{';
	final Character RIGHT_BRACE = '}';
	final Character LEFT_BRACKET = '[';
	final Character RIGHT_BRACKET = ']';
        
    Stack<Character> st = new Stack<Character>();
	
	if(expression.charAt(0) == RIGHT_PAREN ||expression.charAt(0) == RIGHT_BRACE || expression.charAt(0) == RIGHT_BRACKET )
		return false;
        
    for(int i =0; i< expression.length(); i++){
        Character ch = expression.charAt(i);
		//System.out.println("Char "+ch);
        if(ch == LEFT_PAREN || ch == LEFT_BRACE || ch == LEFT_BRACKET)
            st.push(ch);
        else if (!(st.isEmpty())){
			if(st.peek() != null && (ch == RIGHT_BRACE|| ch == RIGHT_PAREN || ch == RIGHT_BRACKET )){
				//System.out.println("st.peek "+st.peek());
				if(ch == RIGHT_BRACE)
					if(st.peek().equals(LEFT_BRACE))
						st.pop();
					else{
						//System.out.println(ch == RIGHT_BRACE && st.peek().equals(LEFT_BRACE));
						return false;
						}
					
				if(ch == RIGHT_PAREN)
					if(st.peek().equals(LEFT_PAREN))
						st.pop();
					else{
						//System.out.println(ch == RIGHT_PAREN && st.peek().equals(LEFT_PAREN));
						return false;
					}
				if(ch == RIGHT_BRACKET)
					if(st.peek().equals(LEFT_BRACKET))
						st.pop();
					else{
						//System.out.println(ch == RIGHT_BRACKET && st.peek().equals(LEFT_BRACKET));
						return false;
					}
			}
		}
    }
     return st.isEmpty();
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            boolean answer = isBalanced(expression);
            if(answer)
                System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
