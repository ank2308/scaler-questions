import java.util.Stack;

public class InvertBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode A = new TreeNode(1) ;
		A.left = new TreeNode(9);
		A.right = new TreeNode(2);
		A.left.left = new TreeNode(6);
		A.right.right = new TreeNode(8);
		InvertBinaryTree ibt = new InvertBinaryTree();
		ibt.invertTree(A);
	}
	public TreeNode invertTree(TreeNode A) {
		TreeNode current = A;
		Stack<TreeNode> treeStack = new Stack<>();
		while(current != null || !treeStack.isEmpty()) {
			while (current != null) {
				invertChild(current);
				if(current.right != null) {
					treeStack.push(current.right);
				}
				current = current.left;				
			}
			if(!treeStack.isEmpty()) {
				current = treeStack.pop();
			}			
		}
		return A;
    }
	
	private TreeNode invertChild(TreeNode A) {
		if(A.left == null && A.right == null) {
			return A;
		}
		if(A.left != null && A.right!=null) {
			TreeNode temp = A.left;
			A.left = A.right;
			A.right = temp;
			return A;
		} 
		if (A.left == null) {
			A.left = A.right;
			A.right = null;
			return A;
		}
		if(A.right == null) {
			A.right = A.left;
			A.left = null;
			return A;
		}
		return A;
	}

}
