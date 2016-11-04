import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RunningMedian {

public static class MinHeap{
	private int[] arr;
	private int size;
	private int capacity;

	
	public MinHeap(){
		capacity = 10;
		arr = new int[capacity];
		size =0;
	
	}
	
	public int getLeftIndex(int index) {return 2*index+1;}
	public int getRightIndex(int index) {return 2*index+2;}
	public int getParentIndex(int childIndex) {return (childIndex-1);}
	
	public int getParent(int childIndex) {return arr[getParentIndex(childIndex)];}
	public int getLeftChild(int index) {return arr[getLeftIndex(index)];}
	public int getRightChild(int index) {return arr[getRightIndex(index)];}
	
	public boolean hasParent(int childIndex) {return getParentIndex(childIndex) >=0;}
		
	public boolean hasLeftChild(int index) {return getLeftIndex(index) < size;}
		
	public boolean hasRightChild(int index) {return getRightChild(index) < size;}
	
	public int getItem(int index) {return arr[index];}
	
	public int[] toArray(){
		return arr;
	}
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
		
		//System.out.println("added item to queue "+ item);
		arr[size] = item;
		size++;
		heapifyUp();
		expandCapacity();
		//System.out.println("Heapified up");
	
	}
	public int getSize(){
		return size;
		}
	
	public int peek(){
		int pk = -1;
		if(!isEmpty()){
			pk = arr[0];
			//System.out.println("pk " + pk);
		}
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
	//when adding new item to heap add at the end and compare it with parent to move it to the right location
	//This implementation depends on the type of heap. minHeap or maxHeap

	public void heapifyUp(){
		int index = size-1;
		//System.out.println(hasParent(index));
		while(hasParent(index) && getItem(index) < getParent(index)){
		
			//System.out.println("Parent " + getParent(index) + " Child " +  getItem(index));
			int parentIndex = getParentIndex(index);
			swap(index, parentIndex);
			index = parentIndex;
		}
	}
		
	
	}

	public static boolean isEven(int num){
		boolean res = false;
		if (num == 0 || num == 1)
			return false;
		if(num%2 == 0)
			res = true;
		return res;
	}
	

	
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		
        int n = in.nextInt();
		MinHeap q = new MinHeap();
		int[] temp;
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
			q.add(a[a_i]);
			
			temp = q.toArray();
			
			int len = a_i+1;
			double med = 0.0;
			
			if(len == 1)
				med = temp[0];
			else if(isEven(len)){
				med = (1.0*(temp[(len/2)-1] + temp[((len/2)+1)-1]))/2;
				//System.out.println("Len, isEven() " +  len + ", " + isEven(len) +" , " + temp[(len/2)-1] + ", " + temp[((len/2)+1)-1]);
				}
			else{
				med = 1.0*temp[((len/2)+1)-1];
				//System.out.println("Len, isEven() " +  len + ", " + isEven(len) +" , " + temp[((len/2)+1)-1]);
				}
			System.out.println(String.format("%.1f",med));		
				
        }
		
    }
}
