
import java.util.*;
import java.lang.Math.*;

public class SubhaUtil{


	public static boolean checkPrime(int n){
	
	
	
	for (int x = 2; x <=Math.sqrt(n); x++)
	{
	
		if ((n==0) || n== 1)
			return false;
		
		if (n%x == 0)
			return false;
			
		
	
	
	}
	return true;
	}
	
	public static boolean isUnique(String str){
	
	boolean res = true;
	
	for (int i =0; i< str.length(); i++){
		System.out.println("i " + str.charAt(i));
		for (int j =i+1; j< str.length(); j++){
		
			
			System.out.println("j "+str.charAt(j));
			if (str.charAt(j) ==  str.charAt(i))
				res = false;
		}
	}
	return res;
	}
	
	public static boolean checkPermutation(String str1, String str2){
	
		int s1 =0;
		int s2 = 0;
		
		for (int i =0; i< str1.length(); i++){
		
			s1 = s1+ str1.charAt(i)
			;
		}
		System.out.println("s1 "+s1);
		for (int i =0; i< str2.length(); i++){
		
			s2 = s2+ str2.charAt(i);
		}
		System.out.println("s2 "+s2);
		
		if (s1 == s2)
			return true;
		else
			return false;
			
	}
	
	public static String URLify(String url, int len){
	
	
		StringBuilder output = new StringBuilder();
		
		for (int i =0; i <len; i++){
		
			if (url.charAt(i) == ' ')
				output.append("%20");
			else
				output.append(url.charAt(i));
		}
		return output.toString();
	}
	
	
	
	
	
	
	
	
	
	
	//test
	public static void main(String[] args)
	{
		//Scanner scn = new Scanner(System.in);
		//int n = Integer.parseInt(scn.next());
		//System.out.println(checkPrime(n));
		
		
		/*System.out.println(isUnique("abcd"));
		System.out.println(isUnique("ggtht"));
		System.out.println(isUnique("abcdee"));*/
		
		/*System.out.println(checkPermutation("abc", "bca"));
		System.out.println(checkPermutation("abc", "bcd"));*/
		
		System.out.println("--"+URLify("Mr John Smith      ", 13)+"----");
		
		
		}
		
	}