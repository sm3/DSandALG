
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class CountingInversions{

/**public static long mergeSort(int[] arr, int[] temp){
	
	long count = mergeSort(arr, temp, 0, arr.length-1);
	return count;

}**/

public static long mergeSort(int[] arr, int[] temp, int leftStart, int rightEnd){

	if(leftStart >= rightEnd)
		return 0;

	long count =0;
	int middle = (leftStart+ rightEnd)/2;
	
	//System.out.println(count);
	count += mergeSort(arr, temp, leftStart, middle);
	count += mergeSort(arr, temp, middle+1, rightEnd);
	count += merge(arr, temp, leftStart, rightEnd);
	
	return count;

	
}

public static long merge(int[] arr, int[] temp, int leftStart, int rightEnd){
	int size = rightEnd - leftStart +1;
	int leftEnd = (rightEnd+leftStart)/2;
	int rightStart = leftEnd+1;
	int left = leftStart;
	int right = rightStart;
	int index = leftStart;
	long count = 0;
	
	while(left <= leftEnd && right <= rightEnd){
		if (arr[left] <= arr[right]){
			temp[index]=arr[left];
			
			left++;
			
		}
		else{
			temp[index] = arr[right];
			right++;
			count += leftEnd +1 - left;
			
			
		}
		index++;
	}
	System.arraycopy(arr, left, temp, index, (leftEnd-left)+1);
	System.arraycopy(arr, right, temp, index, (rightEnd-right)+1);
	System.arraycopy(temp, leftStart, arr, leftStart, size);
	System.out.println("sorted");
	for (int i =0; i < temp.length; i++){
		System.out.print(temp[i] + ", ");
	}
	
	return count;

}
public static long countInversions(int[] arr){
	 int[] temp = new int[arr.length];
	 return mergeSort(arr, temp, 0, arr.length-1);
	
}
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int arr_i=0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            System.out.println(countInversions(arr));
        }
    }

}