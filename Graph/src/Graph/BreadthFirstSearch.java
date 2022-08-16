package Graph;
import Graph.GraphImp;
import java.util.*;
class BreadthFirstSearch {

	public static void addEdge(ArrayList<ArrayList<Integer>> adj,int u,int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	public static int[] BFSUtil(ArrayList<ArrayList<Integer>>adj,int v,int s) {
		boolean[] visited = new boolean[v];
		Queue<Integer> q = new LinkedList<>();
		
		return new int[2];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<v;i++) {
			adj.add(new ArrayList());
		}
	
		addEdge(adj,0,1);
		addEdge(adj,0,4);
		addEdge(adj,1,2);
		addEdge(adj,1,3);
		addEdge(adj,1,4);
		addEdge(adj,2,3);
		addEdge(adj,3,4);	
	}

}
