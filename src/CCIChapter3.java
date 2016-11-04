//CCIChapter3

//3.1 Three in one
import java.util.*;

public class CCIChapter3{

/***
Stack.java
@param <Item> - generic type
Created by: Subha Melapalayam
****/


public static class Stack<Item> implements Iterable<Item>{


private int n = 0; //size of the stack
private Node<Item> first;
private Node<Item> minfirst;

//linked list class
private class Node<Item> {
	private Item item;
	private Node<Item> next;
	}
	
	
//constructor
public Stack(Item item)
{
	first.item = item;
	minfirst.item = item;
	n++;
}

//another constructor
public Stack()
{
first = null;
minfirst = null;
n =0;
}
	
public boolean isMin(Node<Item> node){

	return node.item < min();

	
}
	




//constructor 2 - copy from another stack
//toDo

//pop
public Item pop()
{
Node<Item> toPop = first;
first = first.next;
if(minfirst.item == first.item)
	minfirst = minfirst.next;
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
if(item < minfirst.item){
	Node<Item> oldfirstmin = minfirst;
	minfirst.item = item;
	minfirst.next = oldfirstmin;
	}
	
n++;
}

public Item min(){

return minfirst.item;

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
public Iterator<Item> miniterator()
{
	return new ListIterator<Item>(minfirst);
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
public static void threeinOne(int[] arr){
Stack<Integer> st1 = new Stack<Integer>();
Stack<Integer> st2 = new Stack<Integer>();
Stack<Integer> st3 = new Stack<Integer>();

for (int j = 0; j < arr.length-2; j= j+3){

	st1.push(arr[j]);
	st2.push(arr[j+1]);
	st3.push(arr[j+2]);


}

System.out.println(st1.peek() + ", " + st2.peek() + ", " + st3.peek());


}


public static void main(String[] args){
	//test for dividing an array into 3 stacks
	
	int[] my_arr = new int[10];
	
	for (int i =0; i<9; i++){
		my_arr[i] = i+1;
	}
	
	threeinOne(my_arr);
	
	Stack<Integer> stack = new Stack<Integer>();
		/*Scanner scn = new Scanner(System.in);
		
        while (scn.hasNext()) {
            String item = scn.next();
            if (!item.equals("-"))
                stack.push(item);
            else if (!stack.isEmpty())
                System.out.println(stack.pop() + " ");
        }
        System.out.println("(" + stack.size() + " left on stack)");*/
		
		
		//testing min stack
		stack.push(9);
		System.out.println("min " + stack.min());
		stack.push(5);
		System.out.println("min " + stack.min());
		stack.push(7);
		System.out.println("min " + stack.min());
		stack.push(2);
		System.out.println("min " + stack.min());
		stack.push(4);
		System.out.println("min " + stack.min());
		stack.push(0);
		System.out.println("min " + stack.min());

}

}