import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagOrderlevelTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode A = new TreeNode(3) ;
		A.left = new TreeNode(9);
		A.right = new TreeNode(20);
		A.right.left = new TreeNode(15);
		A.right.right = new TreeNode(7);
		ZigZagOrderlevelTraversal zigZagOrderlevelTraversal = new ZigZagOrderlevelTraversal();
		ArrayList<ArrayList<Integer>> levelElements = zigZagOrderlevelTraversal.zigzagLevelOrder(A);
		System.out.println("abc");
	}
	
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
		ArrayList<ArrayList<Integer>> levelElements = new ArrayList<>();
		Queue<TreeNode> listTree = new LinkedList<TreeNode>();
		boolean isReverse = false;
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
			if(isReverse) {
				Collections.reverse(level);
				levelElements.add(level);
				isReverse = false;
			} else {				
				levelElements.add(level);
				isReverse = true;
			}
			
		}
		return levelElements;
    }
	

}
