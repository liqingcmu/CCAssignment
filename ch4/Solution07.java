package chapeter4;

import java.util.ArrayList;
import java.util.HashMap;
// Use the topological sort
public class Solution07 {
	public GraphNode[] buildOrder(String[] graphNode, String[][] inDegree){
		Graph graph = createGraph(graphNode, inDegree);
		return order(graph);
	}
	public GraphNode[] order (Graph graph){
		GraphNode[] sequence = new GraphNode[graph.getNodes().size()];
		int endOfList = findNoInDegree (sequence, graph.nodes, 0);
		int ptr = 0;
		while (ptr < graph.getNodes().size()){
			GraphNode current = sequence[ptr];
			if (current == null)// There's a cycle in the graph.
				return null;
			//sequence[endOfList] = current;
			ArrayList<GraphNode> children = current.getChildren();
			for (GraphNode child : children){
				child.setInDegree(child.getInDegree() - 1);
			}
			endOfList = findNoInDegree(sequence, children, endOfList);
			ptr++;
		}
		return sequence;
	}
	public int findNoInDegree(GraphNode[] sequence, ArrayList<GraphNode> graphNodes, int index){
		for (GraphNode graphNode : graphNodes){
			if (graphNode.getInDegree() == 0){
				sequence[index] = graphNode;
				index++;
 			}
		}
		return index;
	}
	public Graph createGraph (String[] GraphNode, String[][] inDegrees){
		Graph graph = new Graph();
		for (String graphNode : GraphNode){
			graph.createNode(graphNode);
		}
		for (String[] indegree : inDegrees){
			graph.addEdge(indegree[0], indegree[1]);
		}
		return graph;
	}
	public static class Graph{
		ArrayList<GraphNode> nodes = new ArrayList<GraphNode>();
		private HashMap<String, GraphNode> map = new HashMap<String, GraphNode>();
		
		public GraphNode createNode(String str){
			if (!map.containsKey(str)){
				GraphNode node = new GraphNode(str);
				nodes.add(node);
				map.put(str, node);
			}
			return map.get(str);
		}
		
		public void addEdge (String start, String end){
			GraphNode startPoint = new GraphNode(start);
			GraphNode endPoint = new GraphNode(end);
			startPoint.addNeighbour(endPoint);
		}
		
		public ArrayList<GraphNode> getNodes(){
			return nodes;
		}
	}
	public static class GraphNode {
		private ArrayList<GraphNode> children= new ArrayList<GraphNode>();
		private HashMap<String, GraphNode> map = new HashMap<String, GraphNode>();
		private String name;
		private int inDegree = 0;
		
		public ArrayList<GraphNode> getChildren() {
			return children;
		}
		public void setChildren(ArrayList<GraphNode> children) {
			this.children = children;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getInDegree() {
			return inDegree;
		}
		public void setInDegree(int inDegree) {
			this.inDegree = inDegree;
		}
		public GraphNode(String str){
			this.name = str;
		}
		public void addNeighbour(GraphNode node){
			if (!map.containsKey(node.getName())){
				children.add(node);
				map.put(node.getName(), node);
				node.setInDegree(node.getInDegree() + 1);
			}
		}
	}
	
}
