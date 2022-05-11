
public class HeightOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode A = new TreeNode(3) ;
		A.left = new TreeNode(9);
		A.left.left = new TreeNode(9);A.left.left.left = new TreeNode(9);A.left.left.left.left = new TreeNode(9);
		A.right = new TreeNode(20);
		A.right.left = new TreeNode(15);
		A.right.right = new TreeNode(7);
		A.right.right.right = new TreeNode(7);
		HeightOfBinaryTree heightOfBinaryTree = new HeightOfBinaryTree();
		System.out.println(heightOfBinaryTree.findHeight(A));
	}	
	
	public int findHeight (TreeNode A) {
		if(A==null) {
			return 0;
		}
		return 1+Math.max(findHeight(A.left), findHeight(A.right));
	}	
}
