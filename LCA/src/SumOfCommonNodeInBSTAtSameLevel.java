import java.util.LinkedList;
import java.util.Queue;

public class SumOfCommonNodeInBSTAtSameLevel {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode B = new TreeNode(3) ;
		B.left = new TreeNode(9);
		B.right = new TreeNode(6);
		B.right.left = new TreeNode(15);
		B.right.left.left = new TreeNode(8);
		B.right.right = new TreeNode(1);
		
		TreeNode A = new TreeNode(3) ;
		A.left = new TreeNode(9);
		A.right = new TreeNode(20);
		A.right.left = new TreeNode(15);
		A.right.left.left = new TreeNode(15);
		A.right.right = new TreeNode(7);
		
		SumOfCommonNodeInBSTAtSameLevel obj = new SumOfCommonNodeInBSTAtSameLevel();
		System.out.println(obj.solve(A, B));

	}
	
	public int solve(TreeNode A, TreeNode B) {
		return sumOfCommonNodeInBST(A, B);
    }
	
	public int sumOfCommonNodeInBST(TreeNode A, TreeNode B) {
		Queue<TreeNode> listTreeA = new LinkedList<TreeNode>();
		Queue<TreeNode> listTreeB = new LinkedList<TreeNode>();
		int mod = (int) (Math.pow(10, 9) + 7);
		listTreeA.add(A);
		listTreeB.add(B);
		int sum = 0;
		while(true) {
			if(listTreeA.isEmpty() || listTreeB.isEmpty()) {
				break;
			}
			int nodeCountA = listTreeA.size();
			int nodeCountB = listTreeB.size();
			if(nodeCountA != nodeCountB) {
				break;		
			}
			while (nodeCountA > 0) {
				TreeNode nodeA = listTreeA.poll();
				TreeNode nodeB = listTreeB.poll();
				if(nodeA.val == nodeB.val) {
					sum = (sum + nodeA.val) % mod;
				}
				if(nodeA.left!=null) {
					listTreeA.add(nodeA.left);
				}
				if(nodeA.right!=null) {
					listTreeA.add(nodeA.right);
				}
				if(nodeB.left!=null) {
					listTreeB.add(nodeB.left);
				}
				if(nodeB.right!=null) {
					listTreeB.add(nodeB.right);
				}
				nodeCountA--;
				nodeCountB--;
			}
		}
		
		return sum;
    }

}
