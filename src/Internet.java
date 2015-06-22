import java.util.*;


public class Internet {

	public int articulationPoints(String[] routers) {
		Graph checker = new Graph(routers);
		checker.bfs("0");
		int compareto = checker.size();
		String[] routes = new String[routers.length];
		int count = 0;
		for(int i = 0; i<routers.length; i++){
			String skip = routers[i];
			for (int j = 0; j < routers.length; j++){
				if (routers[j].equals(skip)){
					routes[j] = "-5000";
				} else {
					routes[j] = routers[j];
				}
			}
			Graph trial = new Graph(routes);
			trial.bfs("0");
			if(trial.size()<compareto){
				count++;
			}
		}

		return count;
	}
	public class Graph {
		ArrayList<String> original = new ArrayList<String>();
		TreeMap<String, List<String>> myGraph = new TreeMap<String, List<String>>();

		public Graph(String[] dependencies){
			int vertex = 0;
			for(String s : dependencies)
			{
				String sv = "" + vertex;
				vertex++;

				List<String> list = new ArrayList<String>();

				if (s.equals("")) continue;           // no vertices, don't parse
				String[] a = s.split(" ");

				for (String nextv : a)
				{
					list.add(nextv);
				}

				myGraph.put(sv, list);
			}
		}

		public int size(){
			return original.size();
		}

		public void bfs(String vertex){
			Queue<String> q = new LinkedList<String>();
			bfs(vertex, q);
		}

		private void bfs(String vertex, Queue<String> q){
			q.add(vertex);

			TreeSet<String> visited = new TreeSet<String>();
			visited.add(vertex);
			while(!q.isEmpty()){
				String front = q.remove();
				List<String> adj = myGraph.get(front);
				original.add(front);
				for(String s:adj){
					if(visited.add(s)){
						q.add(s);
					}
				}
			}
		}
	}
}

