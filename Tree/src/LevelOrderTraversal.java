import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode A = new TreeNode(3) ;
		A.left = new TreeNode(9);
		A.right = new TreeNode(20);
		A.right.left = new TreeNode(15);
		A.right.right = new TreeNode(7);
		LevelOrderTraversal orderTraversal = new LevelOrderTraversal();
		orderTraversal.levelOrder(A);
		
		
	}
	
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
		ArrayList<ArrayList<Integer>> levelElements = new ArrayList<>();
		Queue<TreeNode> listTree = new LinkedList<TreeNode>();
		listTree.add(A);
		while(true) {
			if(listTree.isEmpty()) {
				break;
			}
			int nodeCount = listTree.size();
			ArrayList<Integer> level = new ArrayList<Integer>();
			while (nodeCount > 0) {
				TreeNode node = listTree.peek();
				level.add(node.val);
				listTree.poll();
				if(node.left!=null) {
					listTree.add(node.left);
				}
				if(node.right!=null) {
					listTree.add(node.right);
				}
				nodeCount--;
			}
			levelElements.add(level);
		}
		return levelElements;
    }

}
