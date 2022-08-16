package Graph;
import java.util.*;
public class GraphClint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph gh = new Graph();
		gh.addVertex("A");
		gh.addVertex("B");
		gh.addVertex("C");
		gh.addVertex("D");
		gh.addVertex("E");
		gh.addVertex("F");
		gh.addVertex("G");
		gh.addEdge("A","B", 2);
		gh.addEdge("A","D", 3);
		gh.addEdge("B","C", 1);
		gh.addEdge("C","D", 8);
		gh.addEdge("D","E", 10);
		gh.addEdge("E","F", 45);
		gh.addEdge("E","G", 7);
		gh.addEdge("F", "G", 18);
		
//		gh.display();
//		System.out.println(gh.numVertex());
//		System.out.println(gh.numEdge());
//		
//		System.out.println(gh.containsEdges("A", "C"));
//		System.out.println(gh.containsEdges("E","F"));
//		
//		gh.removeEdge("D", "E");
//		gh.display();
//		
//		gh.removeVertex("F");
//		gh.display();
		
//		System.out.println(gh.hasPath("A", "G", new HashMap<>()));
//		System.out.println(gh.dfs("A", "G"));
		gh.bft();
		gh.dft();
//		gh.removeEdge("B", "c");
//		gh.removeEdge("F", "G");
//		System.out.println(gh.isCycle());
//		System.out.println(gh.isConnected());
//		System.out.println(gh.getCC());
	}

}
