//CCIChapter3

//3.1 Three in one

public class CCIChapter3{

public static void threeinOne(int[] arr){
Stack<Integer> st1 = new Stack<Integer>();
Stack<Integer> st1 = new Stack<Integer>();
Stack<Integer> st1 = new Stack<Integer>();

for (int j = 0; j < arr.length-2; j= j+3){

	st1.push(arr[j]);
	st2.push(arr[j+1]);
	st3.push(arr[j+2]);


}

System.out.println(st1.peek() + ", " + st2.peek() + ", " + st3.peek());


}
public static void main(String[] args){

	int[] my_arr = new int[10]();
	
	for (int i =0; i<9; i++){
		my_arr[i] = i+1;
	}
	
	threeinOne(my_arr);

}