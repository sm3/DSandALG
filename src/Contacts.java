import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Contacts{

	public static class Node{
	
		private HashMap<Character, Node> children;
		public int num_count;
		
		public Node(){
			children = new HashMap<Character , Node>();
			num_count = 0;
		}
		
		
		public void setChildren(Character c, Node n){
			if (c != null && n != null)
				children.put(c, n);
		}
		public HashMap<Character, Node> getChildren(){
			return children;
		}
			
	}
	
	public static class Trie{
	
		Node root = new Node();
		HashMap<Character, Node> children = root.getChildren();
		
		
		public void add(String s){
			//read each character and create a node. Store it in var prev. If there are more chars
			// add them as children of current node. If no more chars, set "isCompleteWord" to true
			Node prev = root;
			HashMap<Character, Node> children = root.getChildren();
			for(int i =0; i< s.length(); i++){
				Character c = s.charAt(i);
				Node n = null;
				
				if(children.get(c) != null){
					n = children.get(c);
					n.num_count++;
					}
				else{
					n = new Node();
					n.num_count++;
					//add to parent
					if(prev != null)
						prev.setChildren(c, n);
				}
				prev = n;
				children = n.getChildren();
				
			}//end of for
			//add * to indicate end of string
			prev.setChildren('*', null);
	
	
		}
	
	public void find(String s){
	//for each character find if it is a valid prefix. if it is then see if the next char is a 
	//child of current char. if it not stop searching.
		Node prev = root;
		
		HashMap<Character, Node> children = root.getChildren();
		int count = 0;
		for(int i =0; i< s.length(); i++){
			Character c = s.charAt(i);
			Node n = null;
			if(children != null){
				if(children.get(c) == null){
					System.out.println("0");
					return;
				}
				else
					n = children.get(c);
				if(n.getChildren() != null)
					children = n.getChildren();
				else
					children = null;
				count = n.num_count;
			}
			
		}
		System.out.println(count);
	}

	}
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
		Trie trie = new Trie();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
			if (op.equals("add"))
				trie.add(contact);
			if(op.equals("find"))
				trie.find(contact);
        }
    }

}//end of contacts