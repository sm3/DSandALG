//CCIChapter4

public class CCIChapter4{

	public class Node{
		
	
		String state; //Nodes visited will have this as "visited" possible values "
		String name;
		
		}
		
		

	public class Path{
	
		enum state = {visited, Unvisited;}
		
		public boolean search(Graph g , Node start, Node goal){
		
			if(start == goal) return true;
		
			LinkedList<Node> q = new LinkedList<Node>();
			q.add(start)
			Node n;
			
			
			while (!q.isEmpty()){
				n = q.poll();
				if(n ! = null){
					for (Node u : g.getAdjacentNode(n)){
						if (u ==goal){
							
							return true;
						}
						else{
							q.add(u);
						}
				}
				n.state = state.visited;
			}
							
							
				
			
			
		
		
		
		}
		
		
	
		
		
		
	
		

