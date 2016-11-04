/*****
* given a BST find all possible sequence of values in the array that was used 
* to create the BST
******/
import java.util.*;
public class BSTSequence{
public static class Node
  {
    int data;
    Node left;
    Node right;
    Node parent;
    
    public Node(int item)
    {
      this.data = item;
      this.left = this.right = null;
    }
  }
  /*****
  * Combine 2 arrays but kepp the prefix the same.
  * Given {5, 15}, {15, 15} and 10 create arrays ({10, 5, 15}, {10, 15, 5}}
  *****/
  public static ArrayList<ArrayList<Integer>> combineLists(ArrayList<ArrayList<Integer>> left, ArrayList<ArrayList<Integer>> right, int prefix){
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if(left == null && right == null)
			results.add(new ArrayList<Integer>(Arrays.asList(prefix)));
		if(left != null && right != null){
			for(ArrayList<Integer> list : left){
				
				for(ArrayList<Integer> list2 : right){
					ArrayList<Integer> result = new ArrayList<Integer>();
					result.add(prefix);
					result.addAll(list);
					result.addAll(list2);
					results.add(result);
				}
				
				
			}
			for(ArrayList<Integer> list : right){
				
				for(ArrayList<Integer> list2 : left){
					ArrayList<Integer> result = new ArrayList<Integer>();
					result.add(prefix);
					result.addAll(list);
					result.addAll(list2);
					results.add(result);
				}
				
				
			}
		}
		System.out.println("Results " + results.size());
		for(ArrayList<Integer> list : results){
		System.out.println("{");
			for(int i =0; i < list.size(); i++){
				System.out.println(list.get(i));
			}
		System.out.println("}");
		}
		return results;
  }
  
  /****
  *
  *
  ****/
  public static ArrayList<ArrayList<Integer>> getBSTSequence(Node n){
  
	if(n == null)
		return null;
	
	ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
	ArrayList<ArrayList<Integer>> left = new ArrayList<ArrayList<Integer>>();
	ArrayList<ArrayList<Integer>> right = new ArrayList<ArrayList<Integer>>();
	if(n.left == null && n.right == null){
		System.out.println(n.data);
		results = combineLists( null, null, n.data);
	}
	if(n.left != null){
		//left.add(new ArrayList<Integer>(Arrays.asList(n.left.data)));
		System.out.println(n.left.data);
		results = combineLists(getBSTSequence(n.left), getBSTSequence(n.right), n.data);
		}
	if(n.right != null){
		//right.add(new ArrayList<Integer>(Arrays.asList(n.right.data)));
		System.out.println(n.right.data);
		results = combineLists(getBSTSequence(n.left), getBSTSequence(n.right), n.data);
		}
	
	
	
	return results;
  

  
  }


public static void main(String[] args){

	Node n = new Node(50);
	Node n1 = new Node(20);
	Node n2 = new Node(60);
	Node n3 = new Node(10);
	Node n4 = new Node(25);
	Node n5 = new Node(5);
	Node n6 = new Node(15);
	Node n7 = new Node(70);
	Node n8 = new Node(65);
	Node n9 = new Node(80);
	
	
	n.left = n1;
	n.right = n2;
	n1.left = n3;
	n1.right = n4;
	n3.left = n5;
	n3.right = n6;
	n2.right = n7;
	n7.left = n8;
	n7.right = n9;
	
	ArrayList<ArrayList<Integer>> results = getBSTSequence(n);
	System.out.println("Results " + results.size());
	for(ArrayList<Integer> list : results){
	System.out.println("{");
		for(int i =0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
	System.out.println("}");
	}
	
	
}
}