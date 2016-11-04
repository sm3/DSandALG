//Linked List
public class CCIChapter2_1{
public static class MyLinkedList{

		Node head;
		
		
		public static class Node{
			
			int item;
			Node next = null;
			
			public Node(int data)
			{
				item = data;
				next = null;
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
	
		public  Node getLastNode(){
		
			Node n = head;
			
			while(n.next!=null){
				n=n.next;
			}
			
			return n;
		}
		
			
		
		/*public static void main(String[] args)
		{
			MyLinkedList llist = new MyLinkedList();
			
			llist.head = new Node(1);
			Node node2 = new Node(2);
			Node node3 = new Node(3);
			
			
			llist.head.next = node2;
			node2.next = node3;
			
			printList(llist.head);
		}*/
		
	}//end of MyLinkedList
	
	public static MyLinkedList.Node partition(MyLinkedList.Node node, int x){

    //create 2 lists , 1 for nodes with value < partition value x and 1 for >= x
	
	
	MyLinkedList.Node ln_start = null;
	MyLinkedList.Node gn_start = null;
	MyLinkedList.Node ln = null; 	
	MyLinkedList.Node gn = null;

	//n pts to first node in the list.
	MyLinkedList.Node n = node;
	
	
	
	if(n == null)
		return null;
	
	while(n != null){
		if(n.item <x){
			if (ln == null){
				ln_start = n;
				ln = ln_start;
			}
			else{
				ln.next = n;
				ln = n;
			}
		}
		else{
			if (gn == null){
				
				gn_start = n;
				gn = gn_start;
				//System.out.println("gn_start " + gn_start.item);
			}
			else{
				gn.next = n;
				gn = n;
				}
		}
		
		if(n.next != null)
			n = n.next;
		else
			n = null;
	}
	ln.next = gn_start;
	gn.next = null;
	
	System.out.println(ln_start.item +", " + ln.item);
	System.out.println(ln.next.item +", " + ln.next.next.item);
	System.out.println(gn_start.item +", " + gn.item);
	
	//MyLinkedList.printList(ln_start);
	//MyLinkedList.printList(gn_start);*/
	return ln_start;
	
}

public static MyLinkedList.Node sumLists(MyLinkedList.Node s1, MyLinkedList.Node s2){
	
	int carry_over = 0;
	MyLinkedList.Node value = null;
	MyLinkedList.Node start = null;
	
	
	
	boolean cont = true;
	
	while(cont == true){
		//MyLinkedList.Node next = n.next;//store n.next in next and assign it at the end
		int v = 0;//store values of intermediate sum
		MyLinkedList.Node n = null;
		
		if(s1 != null && s2 != null){
			v = s1.item+s2.item+carry_over;
			carry_over = v >= 10 ? 1 : 0;
			n = new MyLinkedList.Node(v%10) ;
			if(value == null){
				start = n;
				value = start;
			}
			else{
				value.next = n;
				value = n;
			}
			
			s1 = s1.next;
			s2 = s2.next;
			}
			
		else if (s2 == null && s1 != null){
			v = s1.item+carry_over;
			carry_over = v >= 10 ? 1 : 0;
			n = new MyLinkedList.Node(v%10) ;
			if(value == null){
				start = n;
				value = start;
			}
			else{
				value.next = n;
				value = n;
			}
			s1 = s1.next;
			}
		else if (s1 == null && s2 != null){
			v = s2.item+carry_over;
			carry_over = v >= 10 ? 1 : 0;
			n = new MyLinkedList.Node(v%10) ;
			if(value == null){
				start = n;
				value = start;
			}
			else{
				value.next = n;
				value = n;
			}
			s2 = s2.next;
			}			
	
	
	
	if(s1 == null && s2 == null)
		cont = false;
	}
	
	return start;

}

public static MyLinkedList.Node reverse(MyLinkedList.Node s1){

	MyLinkedList.Node head = null;
	
	
	

	while(s1 != null){
		MyLinkedList.Node n = new MyLinkedList.Node(s1.item);
		//n.next will set to null the first iteration which means it will the last node
		n.next = head;
		// current node becomes the head. Every new node inserted after that will become the head in that iteration
		head = n; 
					
		s1 =s1.next;
	}
	MyLinkedList.printList(head);
	return head;
}
	




public static MyLinkedList.Node reverseSumList(MyLinkedList.Node s1, MyLinkedList.Node s2){

	MyLinkedList.Node n = sumLists(reverse( s1), reverse(s2));
	return reverse(n);



}
public static boolean palindrome(MyLinkedList.Node s1){

	MyLinkedList.Node s2 = reverse(s1);
	boolean result = true;
	while(s1 != null && s2 != null){
		if(s1.item != s2.item){
			result = false;
			return result;
		}
		else{
			s1 = s1.next;
			s2 = s2.next;
		}		
	}
	return result;
}

public static MyLinkedList.Node intersection(MyLinkedList.Node s1, MyLinkedList.Node s2){

	
	MyLinkedList.Node  n = null;
	if(s1 == null && s2 == null)
		return null;
	
	while(s1 != null && s2 != null){
		if(s1 == s2){
			n = s1;
			return n;
		}
		s1 = s1.next;
		s2 = s2.next;
	}
	return n;
			
		

}

public static MyLinkedList.Node detectLoop(MyLinkedList.Node s1){

	MyLinkedList.Node n = null;
	MyLinkedList.Node slow = s1;
	MyLinkedList.Node fast = s1;
	
	while(fast.next != null && fast.next.next != null){
		slow = slow.next;
		fast = fast.next.next;
		//when slow.next is pointing to fast then there is a loop
		if (slow == fast){
			System.out.println("slow " + slow.item + " fast "+ fast.item);
			n = slow;
			return n;
		}
	}
	
	return n;

}	
public static void main(String[] args){
	
		/*MyLinkedList llist = new MyLinkedList();
			
			llist.head = new MyLinkedList.Node(1);
			MyLinkedList.Node node2 = new MyLinkedList.Node(8);
			MyLinkedList.Node node3 = new MyLinkedList.Node(9);
			MyLinkedList.Node node4 = new MyLinkedList.Node(5);
			MyLinkedList.Node node5 = new MyLinkedList.Node(2);
			MyLinkedList.Node node6 = new MyLinkedList.Node(3);
			
			
			llist.head.next = node2;
			llist.head.next.next = node3;
			llist.head.next.next.next=node4;
			llist.head.next.next.next.next = node5;
			llist.head.next.next.next.next.next = node6;
			
		MyLinkedList.printList(llist.head);
		System.out.println("------------");
		MyLinkedList.Node n = partition(llist.head, 5);
		MyLinkedList.printList(n);*/
		
		//********test sumlists
		/*MyLinkedList s1 = new MyLinkedList();
		s1.head = new MyLinkedList.Node(6);
		MyLinkedList.Node s1node2 = new MyLinkedList.Node(1);
		MyLinkedList.Node s1node3 = new MyLinkedList.Node(7);
			
		s1.head.next = s1node2;
		s1.head.next.next = s1node3;
		
		MyLinkedList s2 = new MyLinkedList();
			
		s2.head = new MyLinkedList.Node(2);
		MyLinkedList.Node s2node2 = new MyLinkedList.Node(9);
		MyLinkedList.Node s2node3 = new MyLinkedList.Node(5);
			
		s2.head.next = s2node2;
		s2.head.next.next = s2node3;
		
		MyLinkedList.Node sum1 = reverseSumList(s1.head, s2.head);
		MyLinkedList.printList(sum1);*/
		
		//*********test palindrome
		/*MyLinkedList llist = new MyLinkedList();
			
		llist.head = new MyLinkedList.Node(1);
		MyLinkedList.Node node2 = new MyLinkedList.Node(8);
		MyLinkedList.Node node3 = new MyLinkedList.Node(9);
		MyLinkedList.Node node4 = new MyLinkedList.Node(5);
		MyLinkedList.Node node5 = new MyLinkedList.Node(9);
		MyLinkedList.Node node6 = new MyLinkedList.Node(8);
		MyLinkedList.Node node7 = new MyLinkedList.Node(1);
		MyLinkedList.Node node8 = new MyLinkedList.Node(5);	
		llist.head.next = node2;
		llist.head.next.next = node3;
		llist.head.next.next.next=node4;
		llist.head.next.next.next.next = node5;
		llist.head.next.next.next.next.next = node6;
		llist.head.next.next.next.next.next.next = node7;
		llist.head.next.next.next.next.next.next.next = node8;
		
		
		
		System.out.println("Palindrome " + palindrome(llist.head));*/
		
		//****** test intersection
		
		/*MyLinkedList llist = new MyLinkedList();
			
		llist.head = new MyLinkedList.Node(1);
		MyLinkedList.Node node2 = new MyLinkedList.Node(7);
		MyLinkedList.Node node3 = new MyLinkedList.Node(9);
		MyLinkedList.Node node4 = new MyLinkedList.Node(5);
		MyLinkedList.Node node5 = new MyLinkedList.Node(9);
		MyLinkedList.Node node6 = new MyLinkedList.Node(8);
		MyLinkedList.Node node7 = new MyLinkedList.Node(1);
		MyLinkedList.Node node8 = new MyLinkedList.Node(5);	 
		llist.head.next = node2;
		llist.head.next.next = node3;
		llist.head.next.next.next=node4;
		llist.head.next.next.next.next = node5;
		llist.head.next.next.next.next.next = node6;
		llist.head.next.next.next.next.next.next = node7;
		llist.head.next.next.next.next.next.next.next = node8;
		
		MyLinkedList llist2 = new MyLinkedList();
			
		llist2.head = new MyLinkedList.Node(19);
		MyLinkedList.Node node22 = new MyLinkedList.Node(1);
		MyLinkedList.Node node23 = new MyLinkedList.Node(19);
		MyLinkedList.Node node24 = new MyLinkedList.Node(15);
		MyLinkedList.Node node25 = new MyLinkedList.Node(19);
		
		llist2.head.next = node22;
		llist2.head.next.next = node23;
		llist2.head.next.next.next=node24;
		llist2.head.next.next.next.next = node25;
		llist2.head.next.next.next.next.next = node6;
		llist2.head.next.next.next.next.next.next = node7;
		llist2.head.next.next.next.next.next.next.next = node8;
		
		MyLinkedList.Node n = intersection(llist.head, llist2.head);
		System.out.println(n.item);*/
		
		MyLinkedList llist = new MyLinkedList();
			
		llist.head = new MyLinkedList.Node(1);
		MyLinkedList.Node node2 = new MyLinkedList.Node(7);
		MyLinkedList.Node node3 = new MyLinkedList.Node(19);
		MyLinkedList.Node node4 = new MyLinkedList.Node(5);
		MyLinkedList.Node node5 = new MyLinkedList.Node(9);
		MyLinkedList.Node node6 = new MyLinkedList.Node(8);
		MyLinkedList.Node node7 = new MyLinkedList.Node(10);
		MyLinkedList.Node node8 = new MyLinkedList.Node(5);	 
		llist.head.next = node2;
		llist.head.next.next = node3;
		llist.head.next.next.next=node4;
		llist.head.next.next.next.next = node5;
		llist.head.next.next.next.next.next = node6;
		llist.head.next.next.next.next.next.next = node7;
		llist.head.next.next.next.next.next.next.next = node8;
		llist.head.next.next.next.next.next.next.next.next = node5;
		
		
		MyLinkedList.Node n = detectLoop(llist.head);
		System.out.println(n.item);
		
		
			
			
}
	
}
	
