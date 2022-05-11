
public class FindANodeInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode B = new TreeNode(12) ;
		B.left = new TreeNode(9);
		B.right = new TreeNode(15);
		B.right.left = new TreeNode(14);
		B.right.left.left = new TreeNode(13);
		B.right.right = new TreeNode(20);
		FindANodeInBST findANodeInBST = new FindANodeInBST();
		System.out.println(findANodeInBST.solve(B, 18));
	}
	
	public int solve (TreeNode A, int val) {
		while (A!=null) {
			if(A.val == val) {
				return 1;
			} else {
				if(A.val < val) {
					A = A.right;
				} else {
					A = A.left;
				}
			}
		}
		return 0;
	}
	
	private boolean findNode (TreeNode A, int val) {
		if(A.val == val) {
			return true;
		} else {
			if(A.val < val) {
				findNode(A.right, val);
			} else {
				findNode(A.left, val);
			}
		}
		return false;
	}

}
