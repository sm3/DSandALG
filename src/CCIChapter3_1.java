//CCIChapter3_1

/***
Stack.java
@param <Item> - generic type
Created by: Subha Melapalayam
****/
import java.util.*;
public class CCIChapter3_1{
public static class Stack<Item> implements Iterable<Item>{


private int n = 0; //size of the stack
private Node<Item> first;
private Node<Item> last;

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

public static class SetOfStacks<Item>{

	ArrayList<Stack> stacks = new ArrayList<Stack>();
	int cap = 0;
	
	public SetOfStacks(int n){
		this.cap =n;
		Stack<Item> stack = new Stack<Item>();
		stacks.add(stack);
	}
	
	public void push(Item item){
	
	//get the last set.
	//if it is not null or not full then push item to stack
	//if stack is full create a new stack and add it to the arraylist.
	Stack<Item> last = stacks.get(stacks.size()-1);
	if(last != null && last.size() <cap){
		last.push(item);
		System.out.println("last.size() , cap :" +last.size() +" ," + cap);
	}
	else{
		System.out.println("Creating new stack");
		Stack<Item> newStack = new Stack<Item>();
		newStack.push(item);
		stacks.add(newStack);
	}
	
	}
	
	public Item pop(){
	//get the last stack
	//if it is not empty pop
	//after popping if the size of the stack is zero remove it from the arraylist
	Stack<Item> last = stacks.get(stacks.size()-1);
	
	Item data = null;
	if(last != null){
		data = last.pop();
	}
	if (last.size() == 0){
		stacks.remove(last);
	}
	
	return data;
	}
	public int size(){
		return stacks.size();
		}
	public Item popAtIndex(int i){
	//if i > size of arraylist raise exception
	//else get the stack at the given position from the arraylist
	//if stack is not empty, pop
	
	Item item = null;
	
	if(i > stacks.size() || stacks.isEmpty()){
		return null;
	}
	Stack<Item> st = stacks.get(i);
	
	if(st != null ){
		item = st.pop();
		if (st.size() == 0){
			stacks.remove(st);
		}
		else{
			//if the currrent stack has stacks before it, cascade shifting plates so the current place(after pop) is filled
			shift(i);
		}
	
	}
	
	return item;

	}
	
	public void shift(int current_index){
	
		Stack<Item> curr = stacks.get(current_index);
		for(int i = current_index+1; i<= stacks.size()-1; i++){
			Stack<Item> st = stacks.get(i);
			if(st != null && curr.size()<cap){
				
				curr.push(st.pop());
			}
			else
				curr = stacks.get(i);
				current_index = i;
		}
				
	}			
			
}

public static Stack<Integer> sortStack(Stack<Integer> stk){
	
		Stack<Integer> st2 = new Stack<Integer>();
		Integer temp, min;
		System.out.println("stack size " + stk.size());
		
		while (!stk.isEmpty()){
			temp = stk.pop();
			System.out.println("temp " + temp);
			while(!st2.isEmpty() && temp < st2.peek()){
				stk.push(st2.pop());
			}
			st2.push(temp);
		}
		while(!st2.isEmpty()){
			stk.push(st2.pop());			
		}
		return stk;
}
				
	

public static void main(String[] args) {

		//SetOfStacks
        /*SetOfStacks<Integer> stacks = new SetOfStacks<Integer>(3);
		
		stacks.push(1);
		stacks.push(2);
		stacks.push(3);
		System.out.println("Stacks size "+ stacks.size());
		stacks.push(4);
		System.out.println("Stacks size "+ stacks.size());
		stacks.push(5);
		stacks.push(6);
		stacks.push(7);
		System.out.println("Stacks size "+ stacks.size());
		System.out.println(stacks.pop());
		System.out.println("Stacks size "+ stacks.size());
		stacks.push(8);
		//stacks.push(9);
		//stacks.push(10);
		stacks.popAtIndex(1);
		System.out.println("Stacks size "+ stacks.size());
		//System.out.println("(" + stacks.size() + " left on stack)");
		*/
		
		
		//test sortStack
		
		Stack<Integer> stacks = new Stack<Integer>();
		stacks.push(1);
		stacks.push(3);
		stacks.push(8);
		System.out.println("Stacks size "+ stacks.size());
		stacks.push(12);
		System.out.println("Stacks size "+ stacks.size());
		stacks.push(5);
		stacks.push(10);
		stacks.push(7);
		Stack<Integer>  sorted = sortStack(stacks);
		while(!sorted.isEmpty()){
			System.out.println(sorted.pop());
		}
		
		
        
    }
}


