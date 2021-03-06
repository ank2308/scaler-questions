
public class LargestBalancedBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode A = new TreeNode(9);
		A.left = new TreeNode(20);
		A.right = new TreeNode(14);
		A.left.left = new TreeNode(12);
		A.left.right = new TreeNode(11);
		LargestBalancedBinarySearchTree largestBalancedBinarySearchTree = new LargestBalancedBinarySearchTree();
		System.out.println(largestBalancedBinarySearchTree.solve(A));
	}
	
	public int solve(TreeNode A) {
		int a = findMaxBBST(A).maxBalanced;
		return a;
    }
	private class Info {
		boolean isBalanced;
		int min;
		int max;
		int maxBalanced;
		public Info(boolean isBalanced, int min, int max, int maxBalanced) {
			
			this.isBalanced = isBalanced;
			this.min = min;
			this.max = max;
			this.maxBalanced = maxBalanced;
		}
	}
	
	private Info findMaxBBST(TreeNode A) {
		if(A==null) {
			return new Info(true, 0, 0, 0);
		}
		Info LInfo = findMaxBBST(A.left);
		Info RInfo = findMaxBBST(A.right);	
		
		if(A.left == null && A.right == null) {
			return new Info(true, A.val, A.val, 1);
		} else if(A.left == null) {
			boolean isCurrentBalanced = (RInfo.isBalanced && A.val<RInfo.min);
			if(isCurrentBalanced) {
				return new Info(isCurrentBalanced, A.val, Math.max(A.val,RInfo.max), RInfo.maxBalanced+1);
			} else {
				return new Info(isCurrentBalanced, A.val, Math.max(A.val,RInfo.max), 0);
			}
		} else if(A.right == null) {
			boolean isCurrentBalanced = (LInfo.isBalanced && A.val > LInfo.max);
			if (isCurrentBalanced) {
				return new Info(isCurrentBalanced, Math.min(A.val,LInfo.min), A.val, LInfo.maxBalanced+1);
			} else {
				return new Info(isCurrentBalanced, Math.min(A.val,LInfo.min), A.val, 0);
			}
		} else {
			boolean isCurrentBalanced = (LInfo.isBalanced && RInfo.isBalanced && A.val > LInfo.max && A.val< RInfo.min);
			if(isCurrentBalanced) { 
				return new Info(isCurrentBalanced, Math.min(A.val,LInfo.min), Math.max(A.val, RInfo.max), (LInfo.maxBalanced + RInfo.maxBalanced + 1));
			} else {
				if(!LInfo.isBalanced && !RInfo.isBalanced) {
					return new Info(isCurrentBalanced, Math.min(A.val,LInfo.min), Math.max(A.val, RInfo.max), 1);
				} else if (!LInfo.isBalanced) {
					return new Info(isCurrentBalanced, Math.min(A.val,LInfo.min), Math.max(A.val, RInfo.max), RInfo.maxBalanced + 1);				
				} else if (!RInfo.isBalanced) {
					return new Info(isCurrentBalanced, Math.min(A.val,LInfo.min), Math.max(A.val, RInfo.max), LInfo.maxBalanced + 1);
				}
				return new Info(isCurrentBalanced, Math.min(A.val,LInfo.min), Math.max(A.val, RInfo.max), Math.max(LInfo.maxBalanced, RInfo.maxBalanced));				
			}
		}
		
	}

}
