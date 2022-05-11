import java.util.ArrayList;

public class DiameterOfTree {
	
	public static void main(String [] args) {
		TreeNode A = new TreeNode(3) ;
		A.left = new TreeNode(9);
		A.right = new TreeNode(20);
		A.right.left = new TreeNode(15);
		A.right.right = new TreeNode(7);
		DiameterOfTree diameterOfTree = new DiameterOfTree();
		
		System.out.println(diameterOfTree.solve(A));
	}
	private int diameter = -1;
	
	public int solve (TreeNode A) {
		findHeight(A);
		return diameter;
	}
	
	public int findHeight (TreeNode A) {
		if(A == null) {
			return -1;
		}
		int left = findHeight(A.left);
		int right = findHeight(A.right);
		int height = 1 + Math.max(left, right);
		diameter = Math.max(diameter, (2+left+right));
		return height;
	}

}
