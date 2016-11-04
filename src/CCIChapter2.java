import java.util.*;

public class CCIChapter2{
	Node head;

public static class Node{
	
	int data;
	Node next;
	
	public Node(int item){
	
		this.data = item;
		this.next = null;
	}


}



public static void printList(Node h)
		{
		
			while(h != null)
			{
				System.out.println(h.data+" ");
				h = h.next;
			}
		}	
		
public static void removeDups(Node node){
		Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
		Node prev = null;
		
		while(node !=null){
		
			if(ht.containsKey(node.data)){
			
				prev.next = node.next;
				}
			else{
				ht.put(node.data, 1);
				prev = node;
			}
			
			node = node.next;
			}

}
/*public static void removeDups(Node node){

	
	Node n = node;
	
	while(n != null){
		Node runner = n;
		
		while(runner.next !=null){
			if(!(runner.next.data == n.data)){
				
				runner = runner.next;
			
			}
			else{
				runner.next = n.next.next;				
			}
		}
		n = n.next;
	
	}
	

	

}*/

public static int getCount(Node node){
int count = 0;
Node n = node;

	while (n != null){
		count++;
		n=n.next;
	}
	
	return count;
}

public static Node kthTotheLast(Node node, int k){
		Node runner = node;
		
		if(node == null)
			return null;
		for (int i=0; i<k; i++){
			runner = runner.next;
		}
		
		while(node.next != null){
		
			if(runner.next == null)
				return node;
			node = node.next;
			runner = runner.next;
	
		}
		return node;
		


}
public boolean deleteMiddleNode(Node n){
	//if  first.next == null or last == n then return null
	if (this.getCount(n) == 1 || n.next == null)
		return false;
		
	
	
	// else just copy next nodes data to current.
	
	Node next = n;
	n.data = next.data;
	n.next = next.next;
	return true;
		

}



public static void main(String[] args){
	
		CCIChapter2 llist = new CCIChapter2();
			
			llist.head = new Node(1);
			Node node2 = new Node(2);
			Node node3 = new Node(3);
			Node node4 = new Node(4);
			Node node5 = new Node(5);
			Node node6 = new Node(8);
			
			
			llist.head.next = node2;
			llist.head.next.next = node3;
			llist.head.next.next.next=node4;
			llist.head.next.next.next.next = node5;
			llist.head.next.next.next.next.next = node6;
			
			
		//printList(llist.head);	
		//removeDups(llist.head);
		//printList(llist.head);
		Node n = kthTotheLast(llist.head, 2);
		System.out.println(n.data);
			
}
}