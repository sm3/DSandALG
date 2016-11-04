/**
*Celebrity problem
**/
import java.util.*;
import java.io.*;
import java.lang.*;
public class CelebrityProblem{


	public static void checkInput(int input, int min, int max){
	
		if (input < min || input > max)
			System.out.println("Input > "+ max + " or < "+ min);		
			
			
	}
	
	public static int[][] constructMatrix(int[] arr, int row, int col){
	
		int[][] matrix = new int[row][col];
		int m = 0;
		System.out.println(row + " " + col);
		System.out.println(arr);
		for (int i =0; i<row; i++){
			for(int j=0; j<col; j++){
				matrix[i][j] = arr[m];
				System.out.println(matrix[i][j] +" ["+i + "," + j + "]");
				m++;
			}
		}
		System.out.println(matrix);
		
		
		return matrix;
	}
	
	public static int findCelebrity(int[][] matrix , int r, int c){
	
		int res = 1;
		int id = -1;
		
		
		for(int i=0; i<r; i++){
			for (int j=0; j<c; j++){
				if (i==j) 
					continue;
				if(i == id)
					continue;
				if(matrix[i][j] == 1)
					id = j;
				else if(id >= 0 && matrix[i][id] !=1)
					res = 0;
			}
		}

		if (res == 1) return id;
		else
			return -1;
	}
	
	public static void main(String[] args){
	
		Scanner scn = new Scanner(System.in);
		int numOfTests = 0;
		int persons = 0;
		int[] input = new int[] {} ;
		
		if (scn.hasNext()){
			numOfTests = Integer.parseInt(scn.next());
			checkInput(numOfTests,1, 60);
		}
			
		
		
		for (int i =0; i< numOfTests; i++)
		{
			if (scn.hasNext()){
				persons = Integer.parseInt(scn.next());
				checkInput(persons, 1, 40);
			}
			
			//if (scn.hasNext()){
			String[] strs = new String[persons*persons];
			for (int l =0; l< persons*persons; l++){
			
				strs[l] = scn.next();
				//System.out.println("input str "+ line);
				//String[] strs = line.split("\\s+");
			}
				input = new int[strs.length];
				int k =0;
				
				for (String s : strs)
				{
					input[k] = Integer.parseInt(s);
					checkInput(input[k], 0, 1);
					System.out.println("s" + s);
					k++;
				}
				
			//}
			
			int[][] matrix = constructMatrix(input, persons, persons);
			System.out.println(findCelebrity(matrix, persons, persons));
			
		}
		
	}
}
			
			
			
		