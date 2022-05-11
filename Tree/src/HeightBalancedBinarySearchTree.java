public class HeightBalancedBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode A = new TreeNode(1);
		A.left = new TreeNode(2);
		A.right = new TreeNode(3);
		A.right.left = new TreeNode(4);
		A.right.left.right = new TreeNode(5);
		HeightBalancedBinarySearchTree heightBalancedBinarySearchTree = new HeightBalancedBinarySearchTree();
		System.out.println(heightBalancedBinarySearchTree.isValidBST(A));
	}

	private class Info {
		boolean isBalanced;
		int min;
		int max;
		public Info(boolean isBalanced, int min, int max) {
			
			this.isBalanced = isBalanced;
			this.min = min;
			this.max = max;
		}
	}
	
	private Info isHeightBalanced(TreeNode A) {
		if(A==null) {
			return new Info(true, 0, 0);
		}
		Info LInfo = isHeightBalanced(A.left);
		Info RInfo = isHeightBalanced(A.right);	
		
		if(A.left == null && A.right == null) {
			return new Info(true, A.val, A.val);
		} else if(A.left == null) {
			boolean isCurrentBalanced = (RInfo.isBalanced && A.val<RInfo.min);
			return new Info(isCurrentBalanced, A.val, Math.max(A.val,RInfo.max));
		} else if(A.right == null) {
			boolean isCurrentBalanced = (LInfo.isBalanced && A.val > LInfo.max);
			return new Info(isCurrentBalanced, Math.min(A.val,LInfo.min), A.val);
		} else {
			boolean isCurrentBalanced = (LInfo.isBalanced && RInfo.isBalanced && A.val > LInfo.max && A.val< RInfo.min);
			return new Info(isCurrentBalanced, Math.min(A.val,LInfo.min), Math.max(A.val, RInfo.max));
		}
		
	}
	
	public int isValidBST(TreeNode A) {
		if (isHeightBalanced(A).isBalanced) {
			return 1;
		} else {
			return 0;
		}
    }
	
}
