import java.util.ArrayList;
import java.util.Stack;

public class PreOrderTraversalOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode A = new TreeNode(1) ;
		A.left = new TreeNode(9);
		A.right = new TreeNode(2);
		A.right.left = new TreeNode(3);
		A.right.right = new TreeNode(7);
		PreOrderTraversalOfBinaryTree preOrderTraversal = new PreOrderTraversalOfBinaryTree();
		ArrayList<Integer> preOrder = preOrderTraversal.preOrderTraversalIterative(A);
		System.out.println(preOrder.toString());
	}
	public ArrayList<Integer> preOrderTraversal(TreeNode A) {
		ArrayList<Integer> preOrder = new ArrayList<Integer>();
		traversal(A, preOrder);
		return preOrder;
    }
	
	private void traversal (TreeNode A, ArrayList<Integer> preOrder) {
		if(A == null) {
			return;
		}
		preOrder.add(A.val);
		traversal(A.left, preOrder);
		traversal(A.right, preOrder);
		
	}
	
	public ArrayList<Integer> preOrderTraversalIterative(TreeNode A) {
		ArrayList<Integer> preOrder = new ArrayList<Integer>();
		Stack<TreeNode> treeStack = new Stack<>();
		TreeNode curr = A;
		while (curr!=null || !treeStack.isEmpty()) {
			while (curr != null) {
				preOrder.add(curr.val);
				if(curr.right != null) {
					treeStack.add(curr.right);
				}
				curr = curr.left;
			}
			
			if(!treeStack.isEmpty()) {
				curr = treeStack.pop();
			}
		}
		return preOrder;
    }

}
