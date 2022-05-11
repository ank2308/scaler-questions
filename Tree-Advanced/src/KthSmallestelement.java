import java.lang.reflect.Array;
import java.util.ArrayList;

public class KthSmallestelement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode A  = new TreeNode(5);
		A.left = new TreeNode(3);
		A.left.left = new TreeNode(1);
		A.left.right = new TreeNode(4);
		A.right = new TreeNode(8);
		A.right.right = new TreeNode(10);
		KthSmallestelement kthSmallestelement = new KthSmallestelement();
		System.out.println(kthSmallestelement.kthsmallest(A, 1));
	}
	
	public int kthsmallest(TreeNode A, int B) {
		ArrayList<Integer> inorder = new ArrayList<>();
		inorderTraversal(A, inorder, B);
		return inorder.get(B-1);
    }
	
	private void inorderTraversal (TreeNode A, ArrayList<Integer> inOrder, int B) {
		if(A==null) {
			return;
		}
		inorderTraversal(A.left, inOrder, B);
		inOrder.add(A.val);
		if(inOrder.size() == B) {
			return;
		}
		inorderTraversal(A.right, inOrder, B);
	}

}
