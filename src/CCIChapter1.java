import java.util.*;

public class CCIChapter1{

	//1.1 bruteforce
	/*public static boolean isUnique(String s){
	
		boolean result = true;
		char[] chr_arr = s.toCharArray();
		
		for (int i = 0; i< chr_arr.length; i++){
			for(int j = i+1; j<chr_arr.length; j++ ){
				 if (chr_arr[i] == chr_arr[j])
					result = false;
			}
		}
		
		return result;
		
	}*/
	
	//1.1 using hashtable
	public static boolean isUnique(String s){
	
		boolean result = true;
		char[] chr_arr = s.toCharArray();
		Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();
		
		
		for (int i = 0; i< chr_arr.length; i++){
			
			try {
			if (ht.containsKey(chr_arr[i])){
				//System.out.println(ht.containsKey(chr_arr[i]));
				return false;
			}
			else{
			 //System.out.println(ht.toString());
			 ht.put(chr_arr[i], 1);
			 }
			}
			catch (Exception e){
				System.out.println(e.toString());
			}
			
		}
		
		return result;
		
	}
	
	public static boolean learningBitManipulation(String str){
	
		int checker = 0;
		
		for (int i =0; i < str.length(); i++){
		
			int val = str.charAt(i) -'a';
			if ((checker & (1 << val)) > 0){
				System.out.println("val" + val);
				System.out.println(" 1<< val " + (1 << val));
				System.out.println("checker & 1<< val "+ (checker & (1 << val)));
				return false;
			}
			
			
			
			checker |= (1 << val);
		}
		return true;	
			
	}
	
	public static boolean checkPermutation(String str1, String str2){
	
		int s1 =0;
		int s2 = 0;
		//add the ascii values of each letter for each string
		// if they are the same then str2 is a permutation of str1
		for (int i =0; i< str1.length(); i++){
		
			s1 = s1+ str1.charAt(i);
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
	
	
	
	public static boolean palindromePermutation(String str){
	
			Map<Character, Integer> hm = new HashMap<Character, Integer>();
			String l_str = str.toLowerCase();
			for (int i = 0; i < str.length(); i++){
				
				char s = l_str.charAt(i);
				
				if (s != ' '){
					if (hm.containsKey(s)){
						hm.put(s, hm.get(s)+1);
					}
					else{
						hm.put(s, 1);
					}
				}
			}
	
			//Iterate thru the map and see how many of the keys have an single value
			// if it is more than 1 then result is false
			boolean result = true;
			int count = 0;
			for (Map.Entry<Character, Integer> entry : hm.entrySet()){
					
					char k = entry.getKey();
					int v = entry.getValue();
					
					if (v == 1)
						count++;
						
			}
			
			if (count != 1)
				result = false;
				
			return result;
	}
			
	
	public static boolean oneway(String str1, String str2){
	
		char[] c1 = str1.toLowerCase().toCharArray();
		char[] c2 = str2.toLowerCase().toCharArray();
		
		
		int len;
		int edits = 0;
		boolean results = false;
		
	
		//if the difference between str1 and str2 is > 1 then there are more than 
		// one edit to str1. result  = false
		if (Math.abs(str1.length() - str2.length()) > 1)
				return false;
		
		//find the length that is common to both strings and 
		//loop thru letters in both strings
		if (str1.length() <= str2.length())
				len = str1.length();
		else
				len = str2.length();
				
					
				
		for (int i = 0; i< len-1; i++){
		
				if (c1[i] != c2[i]){
					edits++;
					
					//if letters don't match then check current letter in str1 matches letter in i+1 position
					// in str2 and vice versa. if true then make c1 or c2 start from that position and then compare
					// ex: pale and ple. c1[i+1] = 'l' = c2[i] where i = 1 so we make c1 = ['l', 'e'] and continue comparing
					if (c1[i] == c2[i+1]){
						c2= Arrays.copyOfRange(c2, i +1, len);
					}
					else if (c1[i+1] == c2[i]){
						c1 = Arrays.copyOfRange(c1, i+1, len);
					}
				//restart from beginning since both c1 and c2 are now substrings of original strings
				i = 0;
				// len should be set to the new length of  c1 or c2 whichever is shorter.
				len = (c1.length <= c2.length) ? c1.length : c2.length;
				}
		
		}
		
		if (edits <=1)
			results = true;
			
		if (edits <=1 && Math.abs(c1.length - c2.length) > 0)
			results = false;
		
		
		return results;
			
	
	
	
	}
	
	public static void stringCompression(String str){
	
	int count = 0;
	
	char ch = '\0';
	Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();
	
	for (int i = 0; i < str.length(); i++){
	
	
		System.out.println(" ch, str.charAt(i)" + ch +" , "+ str.charAt(i));
		
		
		if (!ht.containsKey(str.charAt(i))){
			ch = str.charAt(i);
			ht.put(ch, 1);
		}			
		else
			ht.put(ch, ht.get(ch)+1);
		 
	}
	StringBuilder sb = new StringBuilder();
	for (Map.Entry<Character, Integer> entry : ht.entrySet()){
		 char k = entry.getKey();
		 Integer v = entry.getValue();
		 
		 if ( k != '\0'){
			sb.append(k+(v.toString()));
		 }
	}
		 
		 
	System.out.println(sb.toString());	
	
		
	}
	
	public static int[][] rotateMatrix(int[][] matrix, int N){
	
			int[][] new_matrix = new int[N][N];
			
			//System.out.println(new_matrix[0].length + ", " + new_matrix[1].length);
			for (int i = 0; i <N; i++){
				int k = N-i-1;
				for(int j =0; j < N; j++){
					new_matrix[i][j] = matrix[j][k];
				}
			}
			return new_matrix;
	
	}
	public static int[][] initializeZeroMatrix(){
		
		int[][] matrix = new int[4][4];
	
		matrix[0][0] = 5;
		matrix[0][1] = 2;
		matrix[0][2] = 8;
		matrix[0][3] = 7;
		
		matrix[1][0] = 9;
		matrix[1][1] = 0;
		matrix[1][2] = 1;
		matrix[1][3] = 2;
		
		matrix[2][0] = 3;
		matrix[2][1] = 4;
		matrix[2][2] = 5;
		matrix[2][3] = 0;
		
		matrix[3][0] = 1;
		matrix[3][1] = 3;
		matrix[3][2] = 6;
		matrix[3][3] = 2;
		
		return matrix;
		}
		

	public static int[][] zeroMatrix(int[][] matrix){
	
		int M = matrix[0].length;
		int N = matrix[1].length;
		Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
		int[][] n = matrix;		
	
		for(int i =0; i<M; i++){
			for(int j =0; j <N; j++){
				if(matrix[i][j] ==0){
				
					System.out.println("(i, j ) " + i + " , " + j);
					ht.put(i,j);
				
				}
			}
		}
		
		
		
		for (Map.Entry<Integer, Integer> entry : ht.entrySet()){
			int k = entry.getKey();
			int v = entry.getValue();
			
			for(int i =0; i<M; i++){
				for(int j =0; j <N; j++){
				  if( i == k)
					n[i][j] =0;
				  if (j == v)
					n[i][j] =0;
				}
					
			}
		}
		
		return n;
			
			
	}
	
	public static boolean isSubstring(String str1, String str2){
		
		return str1.contains(str2);
	
	}
	public static boolean stringRotation(String str1, String str2){
	
		String new_str = str1+str1;
		return isSubstring(new_str, str2);
		
	
	}
	
	public static void main(String[] args){
	
		System.out.println(isUnique("abcde"));
		System.out.println(isUnique("abbcde"));
		learningBitManipulation("abcde");
		learningBitManipulation("abbcde");
		
		
		System.out.println(checkPermutation("abc", "bca"));
		System.out.println(checkPermutation("abc", "bcd"));
		
		System.out.println("--"+URLify("Mr John Smith      ", 13)+"----");
		
		System.out.println(" Palindrome permutation "+ palindromePermutation("Tactmk coooa"));
		
		System.out.println(" One way edits  " + oneway("pale", "plesv"));
		
		System.out.println("String Compression " );
		stringCompression("aabbbCCCCCChhhhKKKKKKKKKK");
		
		int[][] matrix = new int[3][3];
		
		//[[1,2,3],[4,5,6],[7,8,9]];
		int r = 0; 
		for(int i =0; i<3; i++){
			for(int j =0; j <3; j++){
				r = r+1;
				matrix[i][j] = r;
			}
		}
		int[][] res_matrix =  rotateMatrix(matrix, 3);
		for(int i =0; i<3; i++){
			for(int j =0; j <3; j++){
				System.out.println(res_matrix[i][j]);
			}
		}
		
		int[][] z = new int[4][4];
		z = initializeZeroMatrix();
		
		int[][] res_matrix1 = zeroMatrix(z);
		for(int i =0; i<4; i++){
			for(int j =0; j <4; j++){
				System.out.println(res_matrix1[i][j]);
			}
		}
		System.out.println("StringRotation  "  + stringRotation("waterbottle", "erbottlewatx"));
		
	}
}
		
				
			
				