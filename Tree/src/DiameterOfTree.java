import java.util.ArrayList;

public class DiameterOfTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode A = new TreeNode(5090);
		A.left = new TreeNode(9569);
		A.left.left = new TreeNode(3628);
		
		
		DiameterOfTree diameterOfTree = new DiameterOfTree();
		System.out.println(diameterOfTree.solve(A));
	}
	public int solve(TreeNode A) {
		return findDiameter(A, 0);
    }
	private int findDiameter (TreeNode A, int diameter) {
		if(A==null) {
			return diameter;
		}
		if(A.left == null && A.right == null) {
			return diameter+1;
		}
		diameter = findDiameter(A.left, diameter);
		diameter = findDiameter(A.right, diameter);
		return diameter;
	}

}
