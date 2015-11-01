package kthsmallestnumber;
import java.util.*;

 class Node{
	public int row;
	public int col;
	public int value;
	public Node(int row, int col, int value){
		this.row = row;
		this.col = col;
		this.value = value;
	}
}
 
 
public class Solution {
	public static void main(String[] args){
		int[][] matrix = { {1,  3,   5,  7},

				  {2,  4,   8,   9},

				  {3,  5, 11, 15},

				  {6,  8, 13, 18} };
		System.out.print(kthSmallest(matrix, 8));
	}
	  public static int kthSmallest(int[][] matrix, int k) {
	    // Write your solution here
	    if(matrix == null || k <= 0 || (matrix[0].length * matrix.length) < k)
	      return 0;
	    
	    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
	    
	    int ans = matrix[0][0];
	    Queue<Node> queue= new PriorityQueue<Node>(k,new Comparator<Node>(){
	    	public int compare(Node x, Node y){
	    		return x.value - y.value;
	    	}
	    });
	    
	    Node root = new Node(0,0, matrix[0][0]);
	    queue.add(root);
	    while(!queue.isEmpty() && k > 0){
	    	
	    	Node node = queue.poll();
	    	ans = node.value;
	    	int curRow = node.row;
	    	int curCol = node.col;
	    	
	    	if(curRow + 1 < matrix.length && !visited[curRow+1][curCol]){
	    		queue.add(new Node(curRow+1, curCol, matrix[curRow+1][curCol]));
	    		visited[curRow+1][curCol] = true;
	    	}
	    	if(curCol + 1 < matrix[0].length && !visited[curRow][curCol+1]){
	    		queue.add(new Node(curRow, curCol+1,matrix[curRow][curCol+1]));
	    		visited[curRow][curCol+1] = true;
	    	}
	    	k--;
	    }
	    
	    
	    return ans;
	  }
	}