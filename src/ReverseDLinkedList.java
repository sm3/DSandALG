//reverse a doubly linked list
public class ReverseDLinkedList{

	public static class Node{
	
		int data;
		Node next;
		Node prev;
		public Node(int item){
			this.data = item;
			next = prev = null;
		}
	}
	//reverse double linked list.
	public static Node reverse(Node node){
			Node n = node;
			while(n != null){
				System.out.println(" n" + n.data);
				Node next = n.next;
				Node temp = n.prev;
				n.prev = next;
				n.next = temp;
				if (n.prev != null)System.out.println("n. prev "+ n.prev.data);
				if (n.next != null) System.out.println("n.next " + n.next.data);
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
			n1.prev = null;
			n1.next = n2;
			n2.prev = n1;
			n2.next = n3;
			n3.prev = n2;
			n3.next = n4;
			n4.prev = n3;
			n4.next = n5;
			n5.prev = n4;
			n5.next = null;
			
			Node n = reverse(n1);
			System.out.println(n.data);
			while(n != null){
				System.out.println(n.data);
				n = n.next;
			}
	}
}
			
	

