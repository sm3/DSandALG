


//Find the lowest leaf node of a binary tree

import java.util.*;
public class BinaryTreeGoog{

	Node root;

	//constructors
	public BinaryTreeGoog()
	{
		root = null;
	}
	
	public BinaryTreeGoog(int item)
	{
		root = new Node(item);
	}
	
	//helper class Node
	public static class Node{

	int data;
	Node left, right;
	
		//helper constructors
		public Node(){
			data = -1;
			left = right = null;
			}
		public Node(int item){
			data = item;
			left = right = null;
			}
	
	}

	public Node findLowest(Node root){


		Node n = root;


		ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();

		//get Nodes returns an ArrayList of linked lists consisting of nodes at each level
		lists = getNodes(lists, n, 0);

		//last list in the array list must the lowest level
		int lastIndex = lists.size() -1;

		System.out.println("Lowest level " + lastIndex);

		LinkedList<Node> list = lists.get(lastIndex);

		//return a node from this list.
		return list.peek();
	}



		public ArrayList<LinkedList<Node>> getNodes(ArrayList<LinkedList<Node>> lists, Node root, int level){
		
			Node n = root;

		   
			if (n == null) return null;
			LinkedList<Node> list = null;
			//if size ==  level indicates that level has not been processed yet.
			
			if(lists.size() == level){
				list = new LinkedList<Node> ();
				lists.add(list);
			}
			else 
				list = lists.get(level); // if size != level then there exists a Linkedlist for that level
			list.add(n);
			//System.out.println("list size " + list.size() + "at level" +  level);
		  
			getNodes(lists, n.left, level+1);
			getNodes(lists, n.right, level+1);
			
			return lists;

		}




	public void printBinaryTree(String s, Node n, int l){
		int level = l;
		
		System.out.println(s +n.data);
		if (n.left != null)
			printBinaryTree("/" , n.left, level++);
		if (n.right != null)
			printBinaryTree("\\" , n.right, level++);
	
	}
	
	
	public static void main(String[] args){

		BinaryTreeGoog bt = new BinaryTreeGoog();
		
		bt.root = new Node(10);
		bt.root.left = new Node(9);
		bt.root.right = new Node(12);
		
		bt.root.left.left = new Node(5);
		bt.root.left.right = new Node(4);
		bt.root.right.left = new Node(11);
		bt.root.right.right = new Node(14);
		bt.root.right.left.left = new Node(7);
		bt.root.right.left.right = new Node(3);
		bt.root.left.left.left = new Node(21);
		bt.root.left.left.right = new Node(99);
		bt.root.left.left.left.left = new Node(2);
		
		
		
		
	
		bt.printBinaryTree(" " , bt.root, 0);
		
		Node lowest = bt.findLowest(bt.root);
		System.out.println("One of the lowest nodes " +lowest.data);
		
		}




	

}
