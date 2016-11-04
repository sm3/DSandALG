//bitwise operations

public class Bitwise{
/**
* Swap 2 numbers without using arithmetic operations
**/
public static void swapWithoutArithmetic(int a, int b){
System.out.println(Integer.toBinaryString(a));
System.out.println(Integer.toBinaryString(b));
a = a^b;
System.out.println(a);
System.out.println(Integer.toBinaryString(a));
b= a^b;
System.out.println(Integer.toBinaryString(b));
a = a^b;
System.out.println(Integer.toBinaryString(a));
System.out.println("a, b =" + a + ", " + b);


}

/**
* flip a number 
*
**/
public static int flipBinary(int a){
System.out.println(Integer.toBinaryString(a));
int n = a^((1<<64) -1);

System.out.println(Integer.toBinaryString(a^((1<<64) -1)));
return n;
}

/**
* Lonely integer - given array of pairs find the only number which is not part of a pair
* example : 11242 - output = 4
**/
public static int findLonelyInteger(int[] arr){

	int a = 0;
	for(int i =0; i<arr.length; i++){
		System.out.println("a" + a);
		a = a^arr[i];
		
	}
	return a;

}
public static void main(String[] args){

swapWithoutArithmetic(4,10);

System.out.println(flipBinary(8));
int[] arr = new int[] { 1,1,2,4,2,5,8,7,6,8,7,5,6};
System.out.println("lonely int " + findLonelyInteger(arr));
}



}