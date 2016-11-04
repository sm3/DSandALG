
import java.util.*;

class Checker implements Comparator<Player>{



public int compare(Player a, Player b){
	if (a.score == b.score)
		 return a.name.compareToIgnoreCase(b.name);
	else
		return b.score-a.score;
}

/*public void quickSort(Player[] a){

	quickSort(a, 0, a.length-1);
	
	}
public void quickSort(Player[] a, int from, int to){

	int pivot = a[(from+to)/2];
	int index = partition(a, from , to , pivot);
	
	quickSort(a, from, index-1);
	quickSort(a, index, to);
	

}

public int partition(Player[] a, int from, int to, int pivot){

	while(from <= to){
		//keep moving pointer to right if value on the left is <= pivot
		while(compare(a[from], pivot)<0)
			from++;
		//keep moving the pointer to left is the value on the right is >= pivot
		while(compare(a[to],pivot) > 0)
			to--;
		//Now swap out of order elements
		if (from <= to){
		
			Player temp = a[from];
			a[from] = a[to];
			a[to] = temp;
			
			from ++;
			to--;
		}
			
	}
	return from;
			
}
*/


}


class Player {
    String name;
    int score;
    
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

public class Sorting_Comparator{

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();
     
        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}