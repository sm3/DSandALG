//reverse a doubly linked list
public class ReverseSingleLinkedList{

	public static class Node{
	
		int data;
		Node next;
		
		public Node(int item){
			this.data = item;
			next = null;
		}
	}
	//reverse double linked list.
	public static Node reverse(Node node){
			Node n = node;
			
			Node prev = null;
			Node next = n.next;
			n.next = null;
			prev = n;
			n = next;
			while(n != null){
				System.out.println(" n" + n.data);
				next = n.next;				
				if (prev != null)System.out.println(" prev "+ prev.data);
				if (n.next != null) System.out.println("n.next " + n.next.data);
				n.next = prev;
				prev = n;
				if (next == null) 
					return n;
				else
					n = next;
				
			}
			
			return n;
			
	}
	
	public static void main(String[] args){
			
			Node n1 = new Node(5);
			Node n2 = new Node(2);
			Node n3 = new Node(4);
			Node n4 = new Node(3);
			Node n5 = new Node(7);
			
			n1.next = n2;
			
			n2.next = n3;
			
			n3.next = n4;
			
			n4.next = n5;
			
			n5.next = null;
			
			Node n = reverse(n1);
			System.out.println(n.data);
			while(n != null){
				System.out.println(n.data);
				n = n.next;
			}
	}
}
			
	

