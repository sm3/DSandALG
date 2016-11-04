/****
** Given words in a randsom note  and words from magazine, 
** see if the note can be constructed completely from the words from the magazine
*****/

import java.util.*;

public class RandsomNote {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    
    public RandsomNote(String magazine, String note) {
	
		try{
        StringTokenizer st = new StringTokenizer(magazine);
		magazineMap = new HashMap<String, Integer>();
		noteMap = new HashMap<String, Integer>();
		while(st.hasMoreTokens()){
			String token = st.nextToken();
			if(!magazineMap.containsKey(token))
				magazineMap.put(token.toLowerCase(), 1);
			else
				magazineMap.put(token.toLowerCase(), magazineMap.get(token)+1);
		
		}
		}//try
		catch(Exception e){
			System.out.println(e.toString());
		}
		
		try{
		StringTokenizer st2 = new StringTokenizer(note);
		while(st2.hasMoreTokens()){
			String token = st2.nextToken();
			if(!noteMap.containsKey(token))
				noteMap.put(token.toLowerCase(), 1);
			else
				noteMap.put(token.toLowerCase(), noteMap.get(token)+1);
		}
		}//try
		catch(Exception e){
			System.out.println(e.toString());
		}
		
    }	
    
    public boolean solve() {
		boolean result = true;
		Iterator<String> itr = noteMap.keySet().iterator();
		while(itr.hasNext()){
			String word = itr.next();
			//if magazine does not contain the word or the number of particular word in magazine is 
			// less than what is needed to write the note return false
			System.out.println("Word " + word);
			System.out.println( "magazine contains word ? " + magazineMap.containsKey(word));
			System.out.println( "Magazine , note " + magazineMap.get(word) + ", " + noteMap.get(word));
			if(!magazineMap.containsKey(word)){
				return false;
			}
			else{
				if(magazineMap.get(word) < noteMap.get(word))
					return false;
			}
		}
		return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        // Eat whitespace to beginning of next line
        scanner.nextLine();
		String mag = scanner.nextLine();
		String note = scanner.nextLine();
        System.out.println(mag);
		System.out.println(note);
        RandsomNote s = new RandsomNote(mag,note);
        scanner.close();
        
        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}
