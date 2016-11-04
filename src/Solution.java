import java.io.*;
import java.util.*;


public class Solution{

public static void main(String[] args){

Scanner in = new Scanner(System.in);
String s = in.next();

for (int i =1; i<s.length(); i++)
{
	if (s.charAt(i) == s.charAt(i-1)) 
	{
	
		s = s.substring(0, i-1) + s.substring(i+1);
		i = 0;
		System.out.println(s);
		
	}
	
	
}
if (s.length()== 0)
    {
    System.out.println("Empty String");
    }
else
    System.out.println("value" + s);

}
}