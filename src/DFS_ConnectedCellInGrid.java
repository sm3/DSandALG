import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DFS_ConnectedCellInGrid{
    
    public static int getBiggestRegion(int[][] matrix) {
        int n = matrix[0].length;
		int m = matrix.length;
		//System.out.println("Row " + m + ", cols " + n);
		
		int biggest = 0;
		
		for (int i =1; i < m-1; i++){
			
			for(int j=1; j <n-1; j++){
				//check is connected cells have 1
				//if yes then add to count and change i and j
			
				//if biggest is < count set biggest to count
				//System.out.println("biggest, count " + biggest + ", "  + count);
				biggest = Math.max(biggest, getConnectedCellCount(matrix, i, j));
			}
			
		}
		return biggest;
    }
	
	public static boolean isFilled(int value){
		return value == 1;
	}
	public static int getConnectedCellCount(int[][] matrix, int i, int j){
		
		if( i <0 || j < 0 || i >= matrix.length || j >= matrix[0].length) return 0;
		if(matrix[i][j] == 0)
			return 0;
		int count = 1;
		matrix[i][j] = 0;// marking this node as visited
		count += getConnectedCellCount(matrix,i-1,j-1);
		count += getConnectedCellCount(matrix,i-1,j);
		count += getConnectedCellCount(matrix,i-1,j+1);
		count += getConnectedCellCount(matrix,i,j-1);
		count += getConnectedCellCount(matrix,i,j+1);
		count += getConnectedCellCount(matrix,i+1,j-1);
		count += getConnectedCellCount(matrix,i+1,j);
		count += getConnectedCellCount(matrix,i+1,j+1);

		//System.out.println("i, j, count " + i +", " + j + " , " + count);	
		return count;
	}
	
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        System.out.println(getBiggestRegion(grid));
    }
}
