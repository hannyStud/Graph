package Graph2;
import java.util.*;
class Graph2 {
	static ArrayList<ArrayList<Integer>> vertex;
	static int v;
	public Graph2(int v2) {
		// TODO Auto-generated constructor stub
		vertex = new ArrayList<>();
		this.v= v2;
		for(int i=0;i<v2+1;i++) {
			vertex.add(new ArrayList<>());
		}
	}

	static public void addadj(int ver,int adj) {
		vertex.get(ver).add(adj);
		vertex.get(adj).add(ver);
	}
	
	static public void display() {
		for(int i=1;i<=v;i++) {
			System.out.print("["+i+"]"+"=>");
			System.out.println(vertex.get(i));
		}
	}
	public static ArrayList<Integer> bfs(int v,ArrayList<ArrayList<Integer>> adj){
		ArrayList<Integer> result = new ArrayList<>();
		boolean[] visited = new boolean[adj.size()];
		Queue<Integer> q = new LinkedList<>();
		
		for(int j=1;j<v;j++) {
			if(!visited[j]) {
			q.add(j);
			result.add(j);
		while(!q.isEmpty()) {
			int val = q.poll();
			if(!visited[val]) {
				visited[val] = true;
				ArrayList<Integer> res = adj.get(val);
				for(int i=0;i<res.size();i++){
					if(!visited[res.get(i)]) {
						visited[res.get(i)] = true;
						q.add(res.get(i));
						result.add(res.get(i));
					}
				}
			}
			
		}
		}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		Graph2 gh = new Graph2(v);
		gh.addadj(1, 2);
		gh.addadj(1, 3);
		gh.addadj(2, 5);
		gh.addadj(2, 4);
		gh.addadj(3, 5);
		gh.addadj(4, 6);
		gh.addadj(5, 6);
		gh.display();
		System.out.println(gh.bfs(v, gh.vertex));
		
		
}
}
