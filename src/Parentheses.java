/***
Parentheses.java
using Stack.java
**/

import java.io.*;
import java.util.*;


public class Parentheses{

	private static final String LEFT_PAREN = "(";
	private static final String RIGHT_PAREN = ")";
	private static final String LEFT_BRACE = "{";
	private static final String RIGHT_BRACE = "}";
	private static final String LEFT_BRACKET = "[";
	private static final String RIGHT_BRACKET = "]";
	
	
	public static void main(String[] args)
	{
	
	Stack<String> stk = new Stack<String>();
	
	//Push LEFT* untill you hit corresponding RIGHT*
	//if no more to scan , return true if stack is empty else false
	
	Scanner scn = new Scanner(System.in);
	while (scn.hasNext())
	{
		String s = scn.next();
		if (s == LEFT_PAREN || s == LEFT_BRACE || s == LEFT_BRACKET)
		{
			stk.push(s);
		}
		else if (!stk.isEmpty() && (s == RIGHT_PAREN || s== RIGHT_BRACE || s == LEFT_BRACKET))
		{
			if(stk.peek().equals(s))
			{
				stk.pop();
			}
			else
			{
				System.out.println("false");
			}
		}
		
	}
	System.out.println(stk.isEmpty());
	}
	
}	
	
	
	
	
	
	
	