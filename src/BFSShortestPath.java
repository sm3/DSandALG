import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BFSShortestPath{

    public static class Graph {
        
		int[] graph;
		HashMap<Integer, ArrayList<Integer>> edges;
		
		
		
        
        public Graph(int size) {
			graph = new int[size];
			for (int j = 0; j < size; j++){
				graph[j] = j+1;
			}
			edges = new HashMap<Integer, ArrayList<Integer>>();
           
        }

        public void addEdge(int first, int second) {
			//if first exists add second to the listof edges connected to first
			//else create a new arraylist add an edge from first to second.
            if(edges.containsKey(graph[first]))
				(edges.get(graph[first])).add(graph[second]);
			else{
				ArrayList<Integer> e = new ArrayList<Integer>();
				e.add(graph[second]);
				edges.put(graph[first], e);
			}
				
        }
        
        public int[] shortestReach(int startId) { // 0 indexed
            //start from startId
			int[] distances = new int[graph.length];
			for( int l : edges.keySet()){
				ArrayList<Integer> edge = edges.get(l);
				for (int e : edge){
					System.out.println("Edges " + l + "-> " + e);
				}
			}
			
			for (int i = startId+1; i < graph.length; i++){
				//get shortest path from startId to each of nodes in the graph.
				System.out.println("startId, i " +" , " + graph[startId]+ " , " + graph[i]);
				distances[i] = bfs(graph, graph[startId], graph[i]);
			
			}
			return distances;
        }
		
		
	public int bfs(int[] graph, int start, int goal){
	
		if(start == goal)
			return 0;
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		q.add(start);
		int dist = 0;
		ArrayList<Integer> visited = new ArrayList<Integer>();
		
		while(q.peek() != null){
			int s = q.poll();
			System.out.println("s " +  s);
			ArrayList<Integer> neighbors = edges.get(start);
			if(neighbors.size() <=0)
				return -1;
			if (neighbors.size() > 0 && !visited.contains(s)){
				for(int k =0; k < neighbors.size(); k++){
					System.out.println("node, goal ," + neighbors.get(k) + " , "  + goal);
					if (neighbors.get(k) == goal)
						return dist;
					else{
						dist +=6;
						visited.add(s);
						q.add(neighbors.get(k));
					}
				}
			}
					
		}
		return dist;
			
		
    }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        int queries = scanner.nextInt();
        
        for (int t = 0; t < queries; t++) {
            
            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();
            
            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                
                // add each edge to the graph
                graph.addEdge(u, v);
            }
            
            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);
 
            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();            
        }
        
        scanner.close();
    }
}
