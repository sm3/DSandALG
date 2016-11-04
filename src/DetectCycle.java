/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.
*/


public class DetectCycle{

    static class Node {
        int data;
        Node next;
		
		public Node(int item){
			data = item;
			next = null;
		}
		
    }


static boolean hasCycle(Node head) {
    
    if(head == null)
           return false;
   
    Node runner = head;
    Node fast_runner = head;
    
    while(runner.next!= null && fast_runner.next.next!=null){
       runner = runner.next;
       fast_runner = fast_runner.next.next;
       if(runner == fast_runner)
           return true;
    }
    return false;
    

}
public static void main(String[] args){

	Node n = new Node(10);
	Node n1 = new Node(12);
	Node n2 = new Node(18);
	Node n3 = new Node(15);
	Node n4 = new Node(4);
	Node n5 = new Node(6);
	
	n.next = n1;
	n1.next = n2;
	n2.next = n3;
	n3.next = n4;
	n4.next = n5;
	//n5.next = n3;
	
	System.out.println(hasCycle(n));
}

}