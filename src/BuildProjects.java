//Find the order of tasks/projects given their dependencies 
import java.util.*;
public class BuildProjects{


static class Project{

	private String name;
	private ArrayList<Project> children;
	private HashMap<String, Project> map;
	private int dependencies;
	
	//Each project has a list of project it depends on and is depended by other projects
	//ToDo : May be we can build order by just using dependsOn
	public Project(String proj){
		name = proj;
		children = new ArrayList<Project>();
		map = new HashMap<String, Project>();
	} 
	
	int incrementDepencencies(){
		return dependencies++;
	}
	int decrementDepencencies(){
		return dependencies--;
	}
	String getName(){
		return this.name;
	}
	int getDependencies(){
		return dependencies;
	}
	ArrayList<Project> getChildren(){
		return children;
	}
	//addChild(Project p)
	void addChild(Project p){
		if(!map.containsKey(p.name)){
			children.add(p);
			p.incrementDepencencies();
			map.put(p.name, p);
		}
	}
	
	
}

public static class Graph{
	private ArrayList<Project> nodes = new ArrayList<Project>();
	private HashMap<String, Project> map = new HashMap<String, Project>();
	
	public void createNode(String name){
		if(!map.containsKey(name)){
			Project node = new Project(name);
			nodes.add(node);
			map.put(name, node);
		}
		
	}
	
	public Project getNode(String name){
		return map.get(name);
	}
	public ArrayList<Project> getNodes(){
		return nodes;
	}
	public void addEdge(String a , String b){
	
		Project m = this.getNode(a);
		Project n = this.getNode(b);
		/*if(map.containsKey(a)){
			Project m = this.getNode(a);
		}
		else{
			createNode(a);
			Project m = this.getNode(a);
		}
		
		if(map.containsKey(b)){
			Project n = this.getNode(b);
		}
		else{
			createNode(b);
			Project n = this.getNode(b);
		}*/
		
		m.addChild(n);
		
	}
	
	public ArrayList<Project> getNeighbours(Project name){
		return name.getChildren();
			
	}
}
	
	

public static Graph buildGraph(String[] projlist, String[][] dependencies){
	Graph graph = new Graph();
	

	for (int i = 0; i < projlist.length; i++){
		graph.createNode(projlist[i]);
		
	}
	
	
	for(String[] dependency: dependencies){
		graph.addEdge(dependency[0], dependency[1]);
	}
	
	return graph;
		
}

public static Project[] orderNodes(String[] projlist, String[][] dependencies){

	
	Graph g = buildGraph(projlist, dependencies);
	ArrayList<Project> nodes = g.getNodes();
	//print nodes for debugging
	for (int k = 0; k< nodes.size(); k++){
		System.out.println(nodes.get(k).getName());
		ArrayList<Project> ch = nodes.get(k).getChildren();
		for(int l =0; l < ch.size(); l++){
			System.out.println("child "+ ch.get(l).getName());
		}
	}
	Project[] ordered = new Project[projlist.length];
	
	
	//add all nodes with dependencies 0 to the beginning of the list - root nodes
	System.out.println("Nodes : " + nodes.size());
	
	int index = addNoDependencyNode(ordered, nodes, 0);
	System.out.println("index: " + index);
	System.out.println("Ordered length : " + ordered[index-1].getName());
	System.out.println("index: " + index);
	
	int next = 0;
	while(next <ordered.length){
		//this will initiall point to the root nodes.
		Project current = ordered[next];
		
		//circular dependency
		if(current == null)
			return null;
	
		ArrayList<Project> children = current.getChildren();
		if(children.size() >0){
			for(Project p : children){		
				p.decrementDepencencies();
				System.out.println("current child " +p.getName());
			}
			//System.out.println("Inside while - Nodes : " + nodes.size());
			
			index = addNoDependencyNode(ordered, children, index);
			
			System.out.println("Inside while - Ordered : " + ordered[index-1].getName());
			System.out.println("Inside while - index: " + index);
		}
		next++;
		
	}
		
	return ordered;
}

public static int addNoDependencyNode(Project[] ordered, ArrayList<Project> nodes, int index){
	for (Project node : nodes){
		if(node.getDependencies() == 0){
			ordered[index] = node;
			System.out.println("Inside function - Ordered   : " + ordered[index].getName());
			index++;
		}
		//System.out.println("Inside function - Nodes : " + nodes.size());
		
		System.out.println("Inside function - index: " + index);
	}

return index;
}


public static void main(String[] args){

String[] projlist = {"a", "b", "c", "d", "e", "f"};
String[][] dependencies = {{"a", "d"}, {"f", "b"}, {"b", "d"}, {"f", "a"}, {"d", "c"}};
Project[] result = orderNodes(projlist, dependencies);

for (int i = 0; i < result.length; i++){
	System.out.println(result[i].getName());
	}

}
}

