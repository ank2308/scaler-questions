
public class SumOfCommonNodeInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode B = new TreeNode(12) ;
		B.left = new TreeNode(9);
		B.right = new TreeNode(15);
		B.right.left = new TreeNode(14);
		B.right.left.left = new TreeNode(13);
		B.right.right = new TreeNode(20);
		
		TreeNode A = new TreeNode(12) ;
		A.left = new TreeNode(9);
		A.right = new TreeNode(18);
		A.right.left = new TreeNode(15);
		A.right.left.left = new TreeNode(14);
		A.right.right = new TreeNode(23);
		SumOfCommonNodeInBST commonNodeInBST = new SumOfCommonNodeInBST();
		System.out.println(commonNodeInBST.solve(A, B));
	}
	
	public int solve(TreeNode A, TreeNode B) {
		int sum = preOrder(A, B, 0);
		return sum;
		
    }
	
	private int preOrder (TreeNode A, TreeNode B, int sum) {
		if(A == null) {
			return sum;
		}
		int mod = (int) (Math.pow(10, 9) + 7);
		if (findNode(B, A.val)) {
			sum = (sum + A.val) % mod;
		}
		sum = preOrder(A.left, B, sum);
		sum = preOrder(A.right, B, sum);
		return sum;
	}
	
	private boolean findNode (TreeNode B, int val) {
		while (B!=null) {
			if(B.val == val) {
				return true;
			} else {
				if(B.val < val) {
					B = B.right;
				} else {
					B = B.left;
				}
			}
		}
		return false;
	}

}
