package Graph;
import java.util.*;
public class Graph {

	private class Vertex{
		HashMap<String,Integer> nbrs = new HashMap<>();
	}
	
	HashMap<String,Vertex> vtces;
	public Graph(){
		vtces = new HashMap<>();
	}
	
	public int numVertex() {
		return this.vtces.size();
	}
	
	public boolean containsVertex(String vname) {
		return this.vtces.containsKey(vname);
	}
	
	public void addVertex(String vanme) {
		this.vtces.put(vanme, new Vertex());
	}
	
	public void removeVertex(String vname) {
		Vertex vt = vtces.get(vname);
		ArrayList<String> list = new ArrayList<>(vt.nbrs.keySet());
		
		for(String st : list) {
			Vertex vtnbs = vtces.get(st);
			vtnbs.nbrs.remove(vname);
		}
		vtces.remove(vname);
	}
	
	public int numEdge() {
		int count = 0;
		ArrayList<String> list = new ArrayList<>(vtces.keySet());
		for(String st:list) {
			Vertex vtx = vtces.get(st);
			count += vtx.nbrs.size();
		}
		return count/2;
	}
	public boolean containsEdges(String vname1, String vname2) {
		Vertex vt1 = vtces.get(vname1);
		Vertex vt2 = vtces.get(vname2);
		
		if(vt1==null || vt2==null || !vt1.nbrs.containsKey(vname2))
			return false;
		
		return true;
	}
	
	public void addEdge(String vname1,String vname2,int cost) {
		Vertex vt1 = vtces.get(vname1);
		Vertex vt2 = vtces.get(vname2);
		
		if(vt1==null || vt2==null || vt1.nbrs.containsKey(vname2)) {
			return;
		}
		vt1.nbrs.put(vname2,cost);
		vt2.nbrs.put(vname1,cost);
	}
	
	public void removeEdge(String vname1,String vname2) {
		Vertex vt1 = vtces.get(vname1);
		Vertex vt2 = vtces.get(vname2);
		
		if(vt1==null || vt2==null || !vt1.nbrs.containsKey(vname2)) {
			return;
		}
		vt1.nbrs.remove(vname2);
		vt2.nbrs.remove(vname1);
	}
	
	public boolean hasPath(String vname1,String vname2,HashMap<String,Boolean> used) {
		used.put(vname1,true);
		if(containsEdges(vname1,vname2)) {
			return true;
		}
		Vertex vt = vtces.get(vname1);
		ArrayList<String> list = new ArrayList<>(vt.nbrs.keySet());
		for(String st : list) {
			if(!used.containsKey(st) && hasPath(st,vname2,used))
				return true;
		}
		return false;
	}

	public void display() {
		System.out.println("--------------------");
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		for(String key : keys) {
			
			Vertex vt = vtces.get(key);
			System.out.println(key+" : "+vt.nbrs);
		}
		
		System.out.println("--------------------");
	}
	
	private class pair{
		String vname;
		String asf;
	}
	
	public boolean bfs(String src,String dest) {
		HashMap<String,Boolean> visited = new HashMap<>();
		LinkedList<pair> queue = new LinkedList<>();
		
		pair sp =  new pair();
		sp.vname = src;
		sp.asf = src;
		queue.addLast(sp);
		while(!queue.isEmpty()){
			pair re = queue.removeFirst();
			
			if(visited.containsKey(re.vname)) {
				continue;
			}
			visited.put(re.vname,true);
			if(containsEdges(re.vname,dest)) {
				System.out.println(re.asf+dest);
				return true;
			}
			Vertex vt1 = vtces.get(re.vname);
			ArrayList<String> list = new ArrayList<>(vt1.nbrs.keySet());
			for(String st:list) {
				if(!visited.containsKey(st)) {
					pair np = new pair();
					np.vname = st;
					np.asf = re.asf + st;
					queue.addLast(np);
				}
			}
		}
		return false;
	}
	
	public boolean dfs(String src,String dest) {
		HashMap<String,Boolean> visited = new HashMap<>();
		LinkedList<pair> stack = new LinkedList<>();
		
		pair sp =  new pair();
		sp.vname = src;
		sp.asf = src;
		stack.addFirst(sp);
		while(!stack.isEmpty()){
			pair re = stack.removeFirst();
			
			if(visited.containsKey(re.vname)) {
				continue;
			}
			visited.put(re.vname,true);
			if(containsEdges(re.vname,dest)) {
				System.out.println(re.asf+dest);
				return true;
			}
			Vertex vt1 = vtces.get(re.vname);
			ArrayList<String> list = new ArrayList<>(vt1.nbrs.keySet());
			for(String st:list) {
				if(!visited.containsKey(st)) {
					pair np = new pair();
					np.vname = st;
					np.asf = re.asf + st;
					stack.addFirst(np);
				}
			}
		}
		return false;
	}
	
	public void bft() {
		HashMap<String,Boolean> visited = new HashMap<>();
		LinkedList<pair> queue = new LinkedList<>();
		ArrayList<String> list = new ArrayList(vtces.keySet());
		for(String st : list) {// traversal very node
			if(visited.containsKey(st))
				continue;
		pair sp =  new pair();
		sp.vname = st;
		sp.asf = st;
		queue.addLast(sp);
		while(!queue.isEmpty()){
			pair re = queue.removeFirst();
			
			if(visited.containsKey(re.vname)) {
				continue;
			}
			visited.put(re.vname,true);
			System.out.println(re.vname+" "+"via"+" "+re.asf);
			Vertex vt1 = vtces.get(re.vname);
			ArrayList<String> list1 = new ArrayList<>(vt1.nbrs.keySet());
			for(String st1:list1) {
				if(!visited.containsKey(st1)) {
					pair np = new pair();
					np.vname = st1;
					np.asf = re.asf + st1;
					queue.addLast(np);
				}
			}
		}
		}
	}
	
	public void dft() {
		HashMap<String,Boolean> visited = new HashMap<>();
		LinkedList<pair> stack = new LinkedList<>();
		ArrayList<String> list = new ArrayList(vtces.keySet());
		for(String st : list) {// traversal very node
			if(visited.containsKey(st))
				continue;
		pair sp =  new pair();
		sp.vname = st;
		sp.asf = st;
		stack.addFirst(sp);
		while(!stack.isEmpty()){
			pair re = stack.removeFirst();
			
			if(visited.containsKey(re.vname)) {
				continue;
			}
			visited.put(re.vname,true);
			System.out.println(re.vname+" "+"via"+" "+re.asf);
			Vertex vt1 = vtces.get(re.vname);
			ArrayList<String> list1 = new ArrayList<>(vt1.nbrs.keySet());
			for(String st1:list1) {
				if(!visited.containsKey(st1)) {
					pair np = new pair();
					np.vname = st1;
					np.asf = re.asf + st1;
					stack.addFirst(np);
				}
			}
		}
		}
	}
	
	public boolean isCycle() {
		HashMap<String,Boolean> visited = new HashMap<>();
		LinkedList<pair> queue = new LinkedList<>();
		ArrayList<String> list = new ArrayList(vtces.keySet());
		for(String st : list) {// traversal very node
			if(visited.containsKey(st))
				continue;
		pair sp =  new pair();
		sp.vname = st;
		sp.asf = st;
		queue.addLast(sp);
		while(!queue.isEmpty()){
			pair re = queue.removeFirst();
			
			if(visited.containsKey(re.vname)) {
				return true;
			}
			visited.put(re.vname,true);
			Vertex vt1 = vtces.get(re.vname);
			ArrayList<String> list1 = new ArrayList<>(vt1.nbrs.keySet());
			for(String st1:list1) {
				if(!visited.containsKey(st1)) {
					pair np = new pair();
					np.vname = st1;
					np.asf = re.asf + st1;
					queue.addLast(np);
				}
			}
		}
		}
		return false;
	}
	
	public boolean isConnected() {
		HashMap<String,Boolean> visited = new HashMap<>();
		LinkedList<pair> queue = new LinkedList<>();
		ArrayList<String> list = new ArrayList(vtces.keySet());
		int flag = 0;
		for(String st : list) {// traversal very node
			if(visited.containsKey(st))
				continue;
		flag++;
		pair sp =  new pair();
		sp.vname = st;
		sp.asf = st;
		queue.addLast(sp);
		while(!queue.isEmpty()){
			pair re = queue.removeFirst();
			
			if(visited.containsKey(re.vname)) {
				continue;
			}
			visited.put(re.vname,true);
			System.out.println(re.vname+" "+"via"+" "+re.asf);
			Vertex vt1 = vtces.get(re.vname);
			ArrayList<String> list1 = new ArrayList<>(vt1.nbrs.keySet());
			for(String st1:list1) {
				if(!visited.containsKey(st1)) {
					pair np = new pair();
					np.vname = st1;
					np.asf = re.asf + st1;
					queue.addLast(np);
				}
			}
		}
		}
		if(flag > 1)
			return false;
		return true;
	}

	public ArrayList<ArrayList<String>> getCC() {
		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		HashMap<String,Boolean> visited = new HashMap<>();
		LinkedList<pair> queue = new LinkedList<>();
		ArrayList<String> list = new ArrayList(vtces.keySet());
		for(String st : list) {// traversal very node
			if(visited.containsKey(st))
				continue;
		ArrayList<String> subans = new ArrayList<>();
		pair sp =  new pair();
		sp.vname = st;
		sp.asf = st;
		queue.addLast(sp);
		while(!queue.isEmpty()){
			pair re = queue.removeFirst();
			
			if(visited.containsKey(re.vname)) {
				continue;
			}
			subans.add(re.vname);
			visited.put(re.vname,true);
			System.out.println(re.vname+" "+"via"+" "+re.asf);
			Vertex vt1 = vtces.get(re.vname);
			ArrayList<String> list1 = new ArrayList<>(vt1.nbrs.keySet());
			for(String st1:list1) {
				if(!visited.containsKey(st1)) {
					pair np = new pair();
					np.vname = st1;
					np.asf = re.asf + st1;
					queue.addLast(np);
				}
			}
		}
		ans.add(subans);
		}
		return ans;
	}


}

