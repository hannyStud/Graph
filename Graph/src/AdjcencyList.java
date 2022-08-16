import java.util.*;
class AdjcencyList {

	public static void addEdge(ArrayList<ArrayList<Integer>> adjmat,int u,int v) {
		adjmat.get(u).add(v);
		adjmat.get(v).add(u);
	}
	public static void printGraph(ArrayList<ArrayList<Integer> > adj){
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("\nAdjacency list of vertex"
                               + i);
            System.out.print("head");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> "
                                 + adj.get(i).get(j));
            }
            System.out.println();
        }
        }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		ArrayList<ArrayList<Integer>> adjmat = new ArrayList<ArrayList<Integer>>(v);
		for (int i = 0; i < v; i++)
            adjmat.add(new ArrayList<Integer>());
		addEdge(adjmat,0,1);
		addEdge(adjmat,0,4);
		addEdge(adjmat,1,2);
		addEdge(adjmat,1,3);
		addEdge(adjmat,1,4);
		addEdge(adjmat,2,3);
		addEdge(adjmat,3,4);
		printGraph(adjmat);
	}

}
