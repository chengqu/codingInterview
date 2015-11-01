package bipartite;
import java.util.*;

   class GraphNode {
    public int key;
    public List<GraphNode> neighbors;
    public GraphNode(int key) {
      this.key = key;
      this.neighbors = new ArrayList<GraphNode>();
    }
  }
 
public class Solution {
	public static void main(String[] args){
		GraphNode node1 = new GraphNode(1);
		GraphNode node2 = new GraphNode(2);
		GraphNode node3 = new GraphNode(3);
		GraphNode node4 = new GraphNode(4);
		GraphNode node5 = new GraphNode(5);
		GraphNode node6 = new GraphNode(6);
		GraphNode node7 = new GraphNode(7);
		GraphNode node8 = new GraphNode(8);
		node1.neighbors.add(node6);node1.neighbors.add(node7);node1.neighbors.add(node8);
		node2.neighbors.add(node6);node2.neighbors.add(node7);node2.neighbors.add(node8);
		node3.neighbors.add(node6);node3.neighbors.add(node7);node3.neighbors.add(node8);
		node4.neighbors.add(node6);node4.neighbors.add(node7);node4.neighbors.add(node8);
		node5.neighbors.add(node6);node5.neighbors.add(node7);node5.neighbors.add(node8);
		node6.neighbors.add(node1);node6.neighbors.add(node2);node6.neighbors.add(node3);node6.neighbors.add(node4);node6.neighbors.add(node5);
		node7.neighbors.add(node1);node7.neighbors.add(node2);node7.neighbors.add(node3);node7.neighbors.add(node4);node7.neighbors.add(node5);
		node8.neighbors.add(node1);node8.neighbors.add(node2);node8.neighbors.add(node3);node8.neighbors.add(node4);node8.neighbors.add(node5);
		List<GraphNode> graph = new ArrayList<GraphNode>();
		graph.add(node1);graph.add(node2);graph.add(node3);graph.add(node4);graph.add(node5);graph.add(node6);graph.add(node7);graph.add(node8);
		System.out.print(isBipartite(graph));
	}
	public static boolean isBipartite(List<GraphNode> graph) {
	    // write your solution here
	    if(graph == null)
	      return false;
	      
	      Map<GraphNode, Integer> map = new HashMap<GraphNode, Integer>();
	      for(GraphNode root : graph){
	        if(!map.containsKey(root)){
	            map.put(root, 0);
	            Queue<GraphNode> queue = new LinkedList<GraphNode>();
	            queue.add(root);
	            while(!queue.isEmpty()){
	              GraphNode curNode = queue.poll();
	              for(GraphNode node : curNode.neighbors){
	                if(!map.containsKey(node)){
	                  queue.add(node);
	                  map.put(node, (1-map.get(curNode)));
	                } else if(map.get(node) != (1-map.get(curNode))){
	                  return false;
	                }
	              }
	            }
	        }
	      }
	      return true;
	  }
	}