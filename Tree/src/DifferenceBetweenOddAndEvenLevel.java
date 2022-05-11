import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DifferenceBetweenOddAndEvenLevel {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode A = new TreeNode(3) ;
		A.left = new TreeNode(9);
		A.right = new TreeNode(20);
		A.right.left = new TreeNode(15);
		A.right.right = new TreeNode(7);
		DifferenceBetweenOddAndEvenLevel differenceBetweenOddAndEvenLevel = new DifferenceBetweenOddAndEvenLevel();
		System.out.println(differenceBetweenOddAndEvenLevel.solve(A));
		
		
	}
	
	public int solve(TreeNode A) {		
		Queue<TreeNode> listTree = new LinkedList<TreeNode>();
		listTree.add(A);
		int levelorder = 1;
		int sumOfOddLevel = 0;
		int sumOfEvenLevel = 0;
		while(true) {
			if(listTree.isEmpty()) {
				break;
			}
			int nodeCount = listTree.size();
			while (nodeCount > 0) {
				TreeNode node = listTree.peek();
				if(levelorder%2 == 0 ) {
					sumOfEvenLevel = sumOfEvenLevel + node.val;
				} else {
					sumOfOddLevel = sumOfOddLevel + node.val;
				}
				listTree.poll();
				if(node.left!=null) {
					listTree.add(node.left);
				}
				if(node.right!=null) {
					listTree.add(node.right);
				}
				nodeCount--;
			}
			levelorder++;
		}
		return sumOfOddLevel - sumOfEvenLevel;
    }
}
