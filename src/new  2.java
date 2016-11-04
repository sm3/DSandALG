//find Ancestor

public class BuildProjects{


static class project{

	String name;
	ArrayList<Project> dependsOn;
	ArrayList<Project> dependedBy;
	
	//Each project has a list of project it depends on and is depended by other projects
	//ToDo : May be we can build order by just using dependsOn
	public project(String proj){
		name = proj;
		dependsOn = new ArrayList<Project>();
		dependedBy = new ArrayList<Project>();
	}
	
}


public static HashMap<String, ArrayList<Project>> buildOrder(String[] projlist, String[][] dependencies){

	Project[] projects;
	HashMap<String, ArrayList<Project>> map = new HashMap<String, ArrayList<Project>>();

	for (int i = 0; i < projlist.length(); i++){
		Project p = new Project(projlist[i]);
		projects[i] = p;
		map.add(projlist[i], p.dependsOn);
		
	}
	
	for(String[] dependency: dependencies){
		String before = dependency[0];
		String after = dependency[1];
		
		Project b = map.get(before)
		Project a = map.get(after);	
		
		map.put(after, a.dependsOn.add(b));
	}
	
	for(int i=0; i< projects.length(); i++){
	
		System.out.println(projects[i].name, projects[i].dependsOn.toString());
		}
		
}

public static ArrayList<Project> getOrder(){
return null;
}

public static void main(String[] args){

String[] projlist = ["a", "b", "c", "d", "e", "f"];
String[][] dependencies = [["a", "d"], ["f", "b"], ["b", "d"], ["f", "a"], ["d", "c"]];
HashMap<String, ArrayList<Project>> result = buildOrder(projlist, dependencies);

}
}

