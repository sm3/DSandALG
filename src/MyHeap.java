//Heap

import java.util.*;

public class MyHeap{
abstract class Heap{
	
	private int[] arr;
	private int size;
	private int capacity;

	
	public Heap(){
		capacity = 11;
		arr = new int[capacity];
		size =0;
	
	}
	
	public int getLeftIndex(int index) {return 2*index+1;}
	public int getRightIndex(int index) {return 2*index+2;}
	public int getParentIndex(int childIndex) {return (childIndex-1)/2;}
	
	public int getParent(int childIndex) {return arr[getParentIndex(childIndex)];}
	public int getLeftChild(int index) {return arr[getLeftIndex(index)];}
	public int getRightChild(int index) {return arr[getRightIndex(index)];}
	
	public boolean hasParent(int childIndex) {return getParentIndex(childIndex) >=0;}
		
	public boolean hasLeftChild(int index) {return getLeftIndex(index) < size;}
		
	public boolean hasRightChild(int index) {return getRightChild(index) < size;}
	
	public int getItem(int index) {return arr[index];}
	public void swap(int index1, int index2){
	
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	
	}
	public boolean isEmpty(){
		return size ==0;
	}
	public void expandCapacity(){
		if (size == capacity){
			capacity = capacity << 1;
			arr = Arrays.copyOf(arr, capacity);
		}
	}
	public void add(int item){
		expandCapacity();
		arr[size] = item;
		size++;
		heapifyUp();
	
	}
	public int getSize(){
		return size;
		}
	
	public int peek(){
		int pk = -1;
		if(!isEmpty())
			pk = arr[0];
		return pk;
	}
	
	public int poll(){
		int toReturn  = -1;
		if (!isEmpty()){
			toReturn = arr[0];
			arr[0] = arr[size-1];
			size--;
			heapifyDown();
		}
		return toReturn;
		
	}
	
	//remove item at the top i.e arr[0]. move the last item to the top arr[0] = arr[size-1]
	//compare the top item to its children and move it appropriately
	//This implementation depends on the type of heap. minHeap or maxHeap
	
	public abstract void heapifyDown();
	//when adding new item to heap add at the end and compare it with parent to move it to the right location
	//This implementation depends on the type of heap. minHeap or maxHeap
	public abstract void heapifyUp();
}
public static class MinHeap extends Heap{

	
		public void heapifyDown(){
			int index = 0;
			while(hasLeftChild(index)){
				int smallchildindex = getLeftIndex(index);
				if(hasRightChild(index) && getRightChild(index) < getLeftChild(index))
					smallchildindex = getRightIndex(index);
				
				if(getItem(index) > getItem(smallchildindex))
					swap(index, smallchildindex);
				else
					break;
					
				index = smallchildindex;
			}
		}
		
		public void heapifyUp(){
		int index = size-1;
		//System.out.println(hasParent(index));
		while(hasParent(index) && getItem(index) < getParent(index)){
			int parentIndex = getParentIndex(index);
			swap(index, parentIndex);
			index = parentIndex;
		}
	}	
					
	
	}//end of class MinHeap
public static class MaxHeap extends Heap{
	
		
		public void heapifyDown(){
			int index = 0;
			while(hasLeftChild(index)){
				int smallchildindex = getLeftIndex(index);
				if(hasRightChild(index) && getRightChild(index) > getLeftChild(index))
					smallchildindex = getRightIndex(index);
				
				if(getItem(index) < getItem(smallchildindex))
					swap(index, smallchildindex);
				else
					break;
					
				index = smallchildindex;
			}
		}
		public void heapifyUp(){
		int index = size-1;
		//System.out.println(hasParent(index));
		while(hasParent(index) && getItem(index) > getParent(index)){
			int parentIndex = getParentIndex(index);
			swap(index, parentIndex);
			index = parentIndex;
		}
		}
		
	
	}//class MaxHeap
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int range = scanner.nextInt();
        scanner.close();
        
        // Insert random values into heaps:
		MyHeap mh = new MyHeap();
        Heap minHeap = new MinHeap();
        Heap maxHeap = new MaxHeap();
        System.out.println("Insert Number Sequence:");
        for(int i = 0; i < range; i++) {
            int value = (int) (Math.random() * 100);
            minHeap.add(value);
            maxHeap.add(value);
            System.out.print(+ value + " ");
        }
        
        // Remove values from heaps:
        System.out.println("\n\nPoll Values:\n------------\nMinHeap MaxHeap");
        for(int i = 0; i < range; i++) {
            System.out.format("  %-12d", minHeap.poll());
            System.out.format("%-6d\n", maxHeap.poll());
        }
        try {
            minHeap.peek();
        }
        catch(IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        try {
            maxHeap.poll();
        }
        catch(IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}