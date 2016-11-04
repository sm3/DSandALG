import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class IceCreamParlorBinSearch{

	public static int binarySearch(int[] arr, int sum){
			
		return binarySearch(arr, sum, 0, arr.length);
	}
	
	public static int binarySearch(int[] arr, int search, int left, int right){
		
		while(left < right){
		int mid = left + ((right - left)/2);
		
		if((arr[mid]) == search){
			
			return mid;
		}
		else if(arr[mid] > search){
			right = mid-1;
			}
		else if(arr[mid] < search){
			left = mid+1;
			}
		}
		return -1;
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int m = in.nextInt();
            int n = in.nextInt();
            int a[] = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
			}
			
			Arrays.sort(a);
			for(int a_i=0; a_i < n; a_i++){
				int f1 = a[a_i];
				int f2 = m-f1;
				//if the flavors are equal just print the same index
				if (f2>0 || f2 == f1){
					int res = binarySearch(a, f2, a_i, a.length-1);
					System.out.println(a_i +", matches" + res);
					//we need to print index starting from 1. so add one to result
					if(res != -1)
						if((a[a_i]+1+a[res]+1) == m)
							System.out.println((a_i+1)+ " " +(res+1));
				}
				
            }
			
			
			
        }
    }
}
