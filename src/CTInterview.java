
///given a string "aabbbcdaabccbaaaecbaacbr"
//given a pattern "aabc"

// find a solution that will give the longest substring of string1 that contains the pattern
/// for example above answer would be "aabcaacbaa" between d and e of length 10
import java.util.*;
public class CTInterview{

	public static void main(String[] args){
	
	String s = "aacbdaabcaacbaaecbaacbr";
	String pat = "aabc";
	Hashtable<Integer, String> ht = new Hashtable<Integer, String>(); //to store results

	String longest = "";
	int max = 0;
	String leftOver = "";
	int patLen = pat.length(); //store pattern length
	System.out.println("pattern lenth " + patLen);
	String sstr = "";
	boolean flag = false;
	
	//add "$" at the end of the string. If the substring containing "$" is encountered it will fall in the else block below
	s = s+ "$";
	System.out.println(" original string lenth " + s.length());
	//calculate hashcode for pat 
	int patH = pat.hashCode();
	System.out.println("pattern hascode " + patH);
	//calculate hashcode for substring sstr of length pat.length from s.
	
	for (int i =0; i < s.length(); i++){
	
		if(sstr.endsWith("$")){
			//print the longest substring
			System.out.println("Longest substring" + ht.get(max));
			return;
		}
		sstr = s.substring(i, i+patLen);
		System.out.println("Substring : " + sstr);
		
		int sstrH = sstr.hashCode();
		System.out.println("substring hascode" + sstrH);
		
		//if the hashcodes are same, add the first letter to the longest substring. set left_over to a string containing remaining characters
		//in the substring sstr
		if (patH ==sstrH){
			longest = longest+ s.charAt(i);
			
			leftOver = sstr.substring(1, (sstr.length()));
			
			flag = true; // indicates whether we are processing a substring
			
		}
		else{
			if (flag == true){ // indicates our previous pattern search found a matching sub string(true) or not (false)
				//if we are processsing a substring then once we find a mismatch we need to add the leftover characters in the substring
				// to the longest substring found. else no action needed.
				
				longest = longest+ leftOver;
				if(max < longest.length())
					max = longest.length();
				System.out.println("longest substring so far " + longest);
				//add the left_over to ls and add ls and its size to the hashtable.
				ht.put(longest.length(), longest);
				//set i to the character after the mismatch char 
				i = i + leftOver.length();
				System.out.println("Current index after skipping mismatch" + i);
				//set flag to false
				flag = false;
			}
			
			
			
		}
		
	
	}	
	
	
	}
	
}
	
	
	
	
	
	