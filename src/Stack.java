/***
Stack.java
@param <Item> - generic type
Created by: Subha Melapalayam
****/
import java.util.*;

public class Stack<Item> implements Iterable<Item>{


private int n = 0; //size of the stack
private Node<Item> first;

//linked list class
private class Node<Item> {
	private Item item;
	private Node<Item> next;
	}
	
	
//constructor
public Stack(Item item)
{
	first.item = item;
	n++;
}

//another constructor
public Stack()
{
first = null;
n =0;
}
	



//constructor 2 - copy from another stack
//toDo

//pop
public Item pop()
{
Node<Item> toPop = first;
first = first.next;
n--;
return toPop.item;
}

//push
public void push(Item item)
{

Node<Item> oldFirst = first;
first = new Node<Item>();
first.item = item;
first.next = oldFirst;
n++;
}
//peek - return the first item but do not remove from stack
public Item peek()
{
	return first.item;
}
//isEmpty
public  boolean isEmpty()
{
	return first == null;
}

//size
public int size()
{
	return n;
}

//Iterator

public Iterator<Item> iterator()
{
	return new ListIterator<Item>(first);
	}
	
public class ListIterator<Item> implements Iterator<Item>
{
	private Node<Item> current;
	public ListIterator(Node<Item> first) 
	{
		current = first;
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

public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
		Scanner scn = new Scanner(System.in);
		
        while (scn.hasNext()) {
            String item = scn.next();
            if (!item.equals("-"))
                stack.push(item);
            else if (!stack.isEmpty())
                System.out.println(stack.pop() + " ");
        }
        System.out.println("(" + stack.size() + " left on stack)");
    }
}
	
	
		
		

