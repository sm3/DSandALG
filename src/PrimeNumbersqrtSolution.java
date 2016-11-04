import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PrimeNumbersqrtSolution{

	public static boolean checkPrime(int n){
		if(n == 1)
			return true;
		for (int i = 2; i <= Math.sqrt(n); i++){
			if((n%i) == 0)
				return true;
		}
		return false;
	
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for(int a0 = 0; a0 < p; a0++){
            int n = in.nextInt();
			if(checkPrime(n))
				System.out.println("Not Prime");
			else
				System.out.println("Prime");
        }
		
    }
}