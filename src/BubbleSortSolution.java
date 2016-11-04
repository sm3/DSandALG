import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BubbleSortSolution {
    
    public static int bubblesort(int[] a){
        
        boolean isSorted = false;
        int lastSorted = a.length -1;
		int swap_count = 0;
        while(!isSorted){
            isSorted = true;
            for(int i =0; i<lastSorted; i++){
                if(a[i]>a[i+1]){
                    swap(a, i, i+1);
					swap_count++;
                    isSorted = false;
                }
            }
            lastSorted--;
        }
        return swap_count;
    }
    
    
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;       
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        System.out.println("Array is sorted in " + bubblesort(a) + " swaps.");
		System.out.println("First Element: "+a[0]);
		System.out.println("Last Element: "+a[n-1]);

    }
}
