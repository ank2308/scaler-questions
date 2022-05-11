
public class HeightBalancedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode A = new TreeNode(3) ;
		A.right = new TreeNode(20);
		A.right.left = new TreeNode(15);
		A.right.right = new TreeNode(7);
		HeightBalancedBinaryTree heightBalancedBinaryTree = new HeightBalancedBinaryTree();
		System.out.println(heightBalancedBinaryTree.isBalanced(A));
		
	}
	
	private class Info {
		int height;
		boolean isBalanced;
		public Info(int height, boolean isBalanced) {
			this.height = height;
			this.isBalanced = isBalanced;
		}
	}
	
	private Info isHeightBalanced(TreeNode A) {
		if(A==null) {
			return new Info(0, true);
		}
		Info LInfo = isHeightBalanced(A.left);
		Info RInfo = isHeightBalanced(A.right);
		int hCurrent = 1 + Math.max(LInfo.height, RInfo.height);
		boolean isCurrentBalanced = ((Math.abs(LInfo.height - RInfo.height) <=1) && LInfo.isBalanced && RInfo.isBalanced);
		return new Info(hCurrent, isCurrentBalanced);
	}
	
	public int isBalanced(TreeNode A) {
		if (isHeightBalanced(A).isBalanced) {
			return 1;
		} else {
			return 0;
		}
	}

}
