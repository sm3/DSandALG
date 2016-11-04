/**
* Stopwatch.java
*
*/



import java.util.*;
import java.io.*;

public class Stopwatch{

	private final long start;
	
	//Constructor
	public Stopwatch()
	{
		start = System.currentTimeMillis();
		System.out.println(start);
	}
	
	/***
	* Returns elapsed time in seconds since Stopwatch was created.
	***/
	public long elapsedTime(){
	
		long current = System.currentTimeMillis();
		System.out.println (current - start);
		return ((current - start));
	}
	public static int fib(int n)
	{
		if (n <0)
			return 0;
		else if (n == 1)
			return 1;
		else
		{
			return fib(n-1)+fib(n-2);
		}
	}
		

	public static void main(String[] args)
	{
	
	int n = 10;
	Stopwatch timer1 = new Stopwatch();
	
	System.out.println(fib(n));
	
	long elapsed = timer1.elapsedTime();
	System.out.println("Elpased time %.2f{0} Seconds"+Long.toString(elapsed));
	
	
	
	
	}


}