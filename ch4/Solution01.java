package chapeter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// The construction of the graph refer to the link: http://segmentfault.com/a/1190000002685782

public class Solution01 {
	public static class GraphNode {
		public int name;
		public List<GraphNode> list;
		public State state;
		public GraphNode(int name){
			this.name = name;
			this.list = new ArrayList<>();
		}
		public State isState() {
			return state;
		}
		public void setState(State state) {
			this.state = state;
		}
		//TODO
		//To define the method.
		public GraphNode adjacent(){
			// The method implements that find all the adjacent nodes of this.
		}
	}
	// The definition of graph class remains only the construction and method that needed in the core method.
	public class Graph<GraphNode> {
	    List<GraphNode> vertices;
	    List<List<Integer>> edges;
		public Graph() {
			this.vertices = new ArrayList<GraphNode>();
			this.edges = new ArrayList<List<Integer>>();
		}
	}
	enum State {Unvisited, Visited, Visiting};
	public static boolean routeBetween (Graph g, GraphNode start, GraphNode end){
		if (start == end)
			return true;
		LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
		for (GraphNode n : g){
			n.setState(State.Unvisited);
		}
		start.setState(State.Visiting);
		queue.add(start);
		GraphNode u = new GraphNode(-1);
		while (!queue.isEmpty()){
			u = queue.removeFirst();
			if (u != null){
				for (GraphNode v : u.adjacent()){
					if (v.isState() == State.Unvisited){
						if (v == end)
							return true;
						else{
							v.setState(State.Visiting);
							queue.add(v);
						}
					}
				}
				u.setState(State.Visited);
			}
		}
		return false;
	}
}
