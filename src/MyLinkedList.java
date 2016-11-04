//Linked List

public class MyLinkedList{

		Node head;
		
		
		public static class Node{
			
			int item;
			Node next;
			
			public Node(int data)
			{
				this.item = data;
				this.next = null;
			}
		}
		
		public static void printList(Node h)
		{
		
			while(h != null)
			{
				System.out.println(h.item+" ");
				h = h.next;
			}
		}	
		
		public static void main(String[] args)
		{
			MyLinkedList llist = new MyLinkedList();
			
			llist.head = new Node(1);
			Node node2 = new Node(2);
			Node node3 = new Node(3);
			
			
			llist.head.next = node2;
			node2.next = node3;
			
			printList(llist.head);
		}
		
	}
			
			
			