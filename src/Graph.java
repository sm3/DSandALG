public class Graph{

	public class Node{
	
		int item;
		Node left;
		Node right;
		
		public Node(int data)
		{
			item = data;
			left = right = null;
		}
		
	}
	
	//root
	
	Node root;
	
	public Graph()
	{
		root = null;
	}
	
	public Graph(int item)
	{
		root = new Node(item);
	}
	
	public DFS(Graph g, Node n){
	
	
	
	
	
	
	
	public static void main(String[] args)
	{
	
		BTree bt = new BTree();
		
		bt.root = new Node(10);
		bt.root.left = new Node(9);
		bt.root.right = new Node(12);
		
		bt.root.left.left = new Node(5);
		bt.root.left.right = new Node(4);
		bt.root.right.left = new Node(11);
		bt.root.right.right = new Node(14);
		
	}