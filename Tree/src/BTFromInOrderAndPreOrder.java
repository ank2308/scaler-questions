import java.util.HashMap;

public class BTFromInOrderAndPreOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {1, 2, 3};
		int [] B = {2, 1, 3};
		BTFromInOrderAndPreOrder btFromInOrderAndPreOrder = new BTFromInOrderAndPreOrder();
		TreeNode node = btFromInOrderAndPreOrder.buildTree(A, B);
		System.out.println(node.val);
	}
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder.length ==0 || inorder.length ==0 || preorder.length != inorder.length) {
			return null;
		}
		HashMap<Integer, Integer> inMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			inMap.put(inorder[i], i);
		}
		TreeNode root =  constructBT(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inMap);
		return root;
    }
	
	private TreeNode constructBT (int [] preorder, int ps, int pe, int [] inorder, int is, int ie, HashMap<Integer, Integer> inMap) {
		if(ps>pe || is>ie) {
			return null;			
		}
		TreeNode root = new TreeNode(preorder[ps]);
		int rootPos = inMap.get(preorder[ps]);
		int numsLeft = rootPos-is;
		root.left = constructBT(preorder, ps+1, ps+numsLeft, inorder, is, rootPos-1, inMap);
		root.right = constructBT(preorder, ps+numsLeft+1, pe, inorder, rootPos+1, ie, inMap);
		return root;
	}

}
