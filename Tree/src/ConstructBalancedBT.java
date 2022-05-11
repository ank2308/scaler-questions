
public class ConstructBalancedBT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {1,2,3,4,5,6,7,8,9};
		ConstructBalancedBT balancedBT = new ConstructBalancedBT();
		balancedBT.sortedArrayToBST(A);
	}
	public TreeNode sortedArrayToBST(final int[] A) {
		TreeNode node = constructBT(A, 0, A.length-1);
		return node;
    }
	private TreeNode constructBT (int[]A, int low, int end) {
		if(low>end) {
			return null;
		}
		if(low == end) {
			TreeNode root = new TreeNode(A[low]);
			return root;
		}
		int mid = (low + end)/2;
		if(mid==0)
			mid=mid+1;
		TreeNode root = new TreeNode(A[mid]);
		root.left = constructBT(A, low, mid-1);
		root.right = constructBT(A, mid+1, end);
		return root;
	}
}
