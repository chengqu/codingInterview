package checkifbinarytree;
import java.util.*;


 class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int key) {
      this.key = key;
    }
  }
 
public class Solution {
	public static void main(String[] args){
		TreeNode root = new TreeNode(5);
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(8);
		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(6);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node2.left = node4;
		System.out.print(isCompleted(root));
	}
  public static boolean isCompleted(TreeNode root) {
    // Write your solution here.
    if(root == null)
      return true;
      
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    boolean flag = false;
    while(!queue.isEmpty()){
      TreeNode cur = queue.poll();
      if(cur.left != null && cur.right != null){
        queue.add(cur.left);
        queue.add(cur.right);
      } else if (cur.left != null){
    	if(flag)
    		 return false;
        if(cur.left.left != null || cur.left.right != null)
          return false;
        flag = true;
      } else if (cur.right != null){
          return false;
      } 
    }
    return true;
  }
}

