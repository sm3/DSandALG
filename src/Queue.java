

//FIFO
import java.util.*;
public class Queue<Item> implements Iterable<Item>{
	
	private Node<Item> head;
	private Node<Item> last;
	private int n=0;
			
	public class Node<Item>{
	
		private Item item;
		private Node<Item> next;
		
		
		
	}
	
	public Queue(){
		
		head = null;
		last = null;
		n=0;		
		
	}
	
	public void enqueue(Item data){
	
		Node<Item> new_node = new Node<Item>();
		
		new_node.item = data;
		
		if (last == null)
		{
			head = new Node<Item>();
			last = new Node<Item>();
			head = last= new_node;
			n++;
		}
		else
		{ 
			last.next = new_node;
			last = new_node;
			n++;
	
		}
		
	}
	
	public Item dequeue(){
			if(head == null)
				return null;
			else
			{
				Node<Item> temp = head;
				head = head.next;
				n--;
				if(head == null)
				last = null;
				return temp.item;
			}
			
			
			
	}
	
	public int size(){
		return n;
		}
public Iterator<Item> iterator()
{
	return new ListIterator<Item>(head);
}
	
public class ListIterator<Item> implements Iterator<Item>
{
	private Node<Item> current;
	public ListIterator(Node<Item> head)
	{
		current = head;
	}
	
	public boolean hasNext()
	{
		return current !=null;
	}
	
	public void remove()
	{	
		throw new UnsupportedOperationException();
	}
	
	public Item next()
	{	
		if(!hasNext()) throw new NoSuchElementException();
		Item item = current.item;
		current = current.next;
		return item;
		
	}
}
	public static void main(String[] args)
	{
		
		Queue<Integer> q = new Queue<Integer>();
		
		q.enqueue(10);
		q.enqueue(3);
		q.enqueue(7);
		q.enqueue(2);
		q.enqueue(5);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.size());
	}
}		
	
	
		
		
		
		
		
	
	


