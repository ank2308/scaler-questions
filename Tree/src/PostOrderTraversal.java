import java.util.ArrayList;

public class PostOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode A = new TreeNode(1) ;
//		A.left = new TreeNode(9);
		A.right = new TreeNode(2);
		A.right.left = new TreeNode(3);
//		A.right.right = new TreeNode(7);
		PostOrderTraversal orderTraversal = new PostOrderTraversal();
		orderTraversal.postorderTraversal(A);
	}
	public ArrayList<Integer> postorderTraversal(TreeNode A) {
		ArrayList<Integer> postOrder = new ArrayList<Integer>();
		traversal(A, postOrder);
		return postOrder;
    }
	
	private void traversal (TreeNode A, ArrayList<Integer> postOrder) {
		if(A == null) {
			return;
		}
		traversal(A.left, postOrder);
		traversal(A.right, postOrder);
		postOrder.add(A.val);
	}
}
