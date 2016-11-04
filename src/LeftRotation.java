import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LeftRotation{

    public static int[] arrayLeftRotation(int[] a, int n, int k) {
        
        if (k == 0)
            return a;
        
        for(int j = 0; j < k; j++){
		
           if(a.length == 0 || a.length == 1)
                return a;
           //save the last elements value
           int last = a[0];
           //put next elements value in the current position
           for (int i = 0; i < a.length-1; i++){
				System.out.println("i " +  i + "a[i] " + a[i] + "a[i+1] " + a[i+1]);
                a[i]=a[i+1];
            }
			System.out.println("k for loop"+ a[0]);
           //finally add value for last position that was in a[0]
           a[a.length-1] = last;
        }
        
        return a;
      
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
      
        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");
      
        System.out.println();
      
    }
}
