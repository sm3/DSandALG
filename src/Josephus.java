import java.io.*;
import java.util.*;

public class Josephus{

public static void main(String args[]){
	int m = Integer.parseInt(args[0]);
	int n = Integer.parseInt(args[1]);
	
	Queue<Integer> q = new PriorityQueue<Integer>();
	for (int i = 0; i<n; i++)
	{
		q.add(i);
	}
	System.out.println(q);
	while (!q.isEmpty())
	{
		
		for (int i = 0; i< m-1; i= i++)
		{
			q.add(q.poll());
			
		}
		System.out.println(q.poll()+ " ");
	}
	
	System.out.println(q);
}
}