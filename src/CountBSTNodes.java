/**
* CountBSTNodes
*
**/

public class CountBSTNodes{



	Node root;

	//constructors
	public CountBSTNodes()
	{
		root = null;
	}
	
	public CountBSTNodes(int item)
	{
		root = new Node(item);
	}

	public static class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

  
	
		
	int getCountOfNodes(Node root, int low, int high, int total_count) {
		
		
		Node n = root;
		int count = 0;
		
		if (n != null) System.out.println("root.data " + n.data);
		System.out.println("count " + total_count);
		if (n == null)
			return -1;
			
		
		if (n.data > low && n.data < high)
		{
			System.out.println("data, low, high " + n.data + "," + low + ","+ high);
			count++;
			
		}
		
		
		getCountOfNodes(n.left, low, high, total_count+count);
		getCountOfNodes(n.right, low, high, total_count+count);
		
		
		
		return total_count;
		}
		
			
    
    int getCountOfNode(Node root, int low, int high) 
    {
        // Your code here
		int count = getCountOfNodes(root, low, high,0);
		
		return count;
			
		
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

		CountBSTNodes bt = new CountBSTNodes();
		
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
		
		System.out.println("nodes in range " + bt.getCountOfNode(bt.root, 2, 99));
		
		}
}