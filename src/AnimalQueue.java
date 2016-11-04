/****
* Animal Queue
* Queue holds only dogs and cats. People can adopt only oldest entry into the shelter
* If they prefer dog the oldest entry that is a dog gets adopted, same for cat
*****/

import java.util.*;
/****
* Abstract class  - Animal
* contains order info and the type of animal (Dog or Cat)
***/
abstract class Animal{

public int order;
protected String name;
public Animal(String a_name){
	this.name = a_name;
}
public int getOrder(){
	return this.order;
	}
public void setOrder(int ord){
	this.order = ord;
	}
}//Animal

/***
* Dog extents Animal class
*
***/
 class Dog extends Animal{
	public Dog(String a_name){
		
		super(a_name);
	}
}
/***
* Cat - an extension of Animal class
*
***/
 class Cat extends Animal{
	
	public Cat(String a_name){
		
		super(a_name);
	}
}
/***
*  AnimalQueue - an FIFO based on the order of entry
*  the queue is an addition 2 separate queues one for Dogs and one for Cats
*  Uses LinkedList structure for the queues
*****/

public class AnimalQueue{

	int order = 0;
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	
	//check if animal is instance of dog or cat
	//set order and add to appropriate queue
	public void enqueue(Animal animal){
		order++;
		animal.setOrder(order);
		if(animal instanceof Dog)
			dogs.add((Dog)animal);
		else if(animal instanceof Cat)
			cats.add((Cat)animal);
		else
			order--; //if the animal is neither cat nor dog undo order increment
		
	
	}
	//oldest entry gets dequeues first
	public Animal dequeueAny(){
		if(dogs.peek().getOrder() <= cats.peek().getOrder())
			return dogs.poll();
		else
			return cats.poll();
	
	}
	//oldest entry that is a dog gets dequeued
	public Dog dequeueDog(){
		
			return dogs.poll();
	
	}
	//oldest entry that is a cat gets dequeued
	public Cat dequeueCat(){
			return cats.poll();
	}
	
	//test
	public static void main(String[] args){
	
		AnimalQueue animal_q = new AnimalQueue();
		animal_q.enqueue(new Dog("Dog"));
		animal_q.enqueue(new Cat("Cat"));
		animal_q.enqueue(new Dog("Dog"));
		animal_q.enqueue(new Dog("Dog"));
		animal_q.enqueue(new Cat("Cat"));
		Animal animal = animal_q.dequeueAny();
		System.out.println("animal.name, order "  + animal.name + ", "  + animal.getOrder());
		Animal animal2 = animal_q.dequeueDog();
		System.out.println("animal.name, order "  + animal2.name + ", "  + animal2.getOrder());
		Animal animal3 = animal_q.dequeueCat();
		System.out.println("animal.name, order "  + animal3.name + ", "  + animal3.getOrder());
		
	
	
	}
	
}
	
	




