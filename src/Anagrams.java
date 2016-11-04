import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Anagrams {
    public static int numberNeeded(String first, String second) {
	
		Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();
	
		for(int j =0; j<second.length(); j++){
		
			if(!ht.containsKey(second.charAt(j)))
				ht.put(second.charAt(j), 1);
			else{
				char c = second.charAt(j);
				ht.put(c, ht.get(c)+1);
			}
		}	
		
				
        
        for(int i=0; i<first.length(); i++){
            char c = first.charAt(i);
			//System.out.println("char" +c);
			if(ht.containsKey(c) && ht.get(c) > 0){
					second = second.replaceFirst(Character.toString(c),"0");
                    first = first.replaceFirst(Character.toString(c), "0");
					ht.put(c, ht.get(c)-1); //decrement the number of occurence of the char everytime you see it in first
			}
			/*
            for(int j =0; j<second.length(); j++){
                int index = second.indexOf(c);
				//System.out.println("index" + index);
                //look for each char in first in second, if found set the char in both strings to 0
                if(index != -1){
                    second = second.replaceFirst(Character.toString(c),"0");
                    first = first.replaceFirst(Character.toString(c), "0");
					break;
                }
            }*/
        }
		//System.out.println(first);
		//System.out.println(second);
		int count = 0;
		for(int i=0; i<first.length(); i++){
			if(first.charAt(i) != '0')
				count++;
		}
		for(int i=0; i<second.length(); i++){
			if(second.charAt(i) != '0')
				count++;
		}
		
		return count;
      
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String first = in.next();
        String second = in.next();
        System.out.println(numberNeeded(first, second));
    }
}
