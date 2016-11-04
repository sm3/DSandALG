import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TaleOfTwoStacks{
    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack
			if(value != null)
				stackNewestOnTop.push(value);
			else
				return;
        }

        public T peek() {
			T t;
			if(stackOldestOnTop.isEmpty()){
				move();
				t = stackOldestOnTop.peek();
				//moveBack();
			}
			else{
				t = stackOldestOnTop.peek();
			}
			return t;
		
             
        }

        public T dequeue() {
            T t;
			if(stackOldestOnTop.isEmpty()){
				move();
				t = stackOldestOnTop.pop();
				//moveBack();
			}
			else{
				t = stackOldestOnTop.pop();
			}
			return t;
        }
		
		public void move(){
		
			while(!stackNewestOnTop.isEmpty()){
				stackOldestOnTop.push(stackNewestOnTop.pop());
			}
		
		}
		
		public void moveBack(){
			while(!stackOldestOnTop.isEmpty()){
				stackNewestOnTop.push(stackOldestOnTop.pop());
			}
		}
    }

    
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
