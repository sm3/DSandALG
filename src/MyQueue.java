//MyQueue

/*****
*  MyQueue.java
*  Implements a queue using 2 stacks.
******/

import java.util.*;

public class MyQueue<Item>{
	Stack<Item> st1, st2;
	

    public MyQueue(){
		st1 = new Stack<Item>();
		st2 = new Stack<Item>();
	 
	}
/***
* helper class Stack
@param <Item> - generic type
Created by: Subha Melapalayam
****/


public static class Stack<Item> implements Iterable<Item>{


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
}

	
 
 public void enqueue(Item item){
	st1.push(item);
 
 }
 
 public Item dequeue(){
 
	Item data = null;
	
	while(!st1.isEmpty()){
	
		st2.push(st1.pop());
	}
	data = st2.pop();
	/*while(!st2.isEmpty()){
	
		st1.push(st2.pop());
	}*/
	return data;
 }

 
 
 public static void main(String[] args){
 
 MyQueue<Integer> q = new MyQueue<Integer>();
	q.enqueue(1);
	q.enqueue(2);
	q.enqueue(3);
	q.enqueue(4);
	q.enqueue(5);
	System.out.println(q.dequeue());
	System.out.println(q.dequeue());
	System.out.println(q.dequeue());
 
 
 
 }

}
