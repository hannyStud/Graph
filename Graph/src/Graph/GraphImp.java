package Graph;
import java.util.ArrayList;
import java.util.Scanner;
class GraphImp{
	
	int v;
	static ArrayList<ArrayList<Integer>> adj;
	GraphImp(int v){
		this.v = v;
		adj = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<v;i++) {
			adj.add(new ArrayList());
		}
	}
	
	public static void addEdge(int u,int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int V = sc.nextInt(); 
		GraphImp g = new GraphImp(V);

		g.addEdge(0,1);
		g.addEdge(0,4);
		g.addEdge(1,2);
		g.addEdge(1,3);
		g.addEdge(1,4);
		g.addEdge(2,3);
		g.addEdge(3,4);
	}

}
