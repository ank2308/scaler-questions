import java.util.HashMap;

public class BTFromPreOrderAndPostOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode buildTree(int[] preorder, int[] postorder) {
		if(preorder.length == 0 || postorder.length == 0 || preorder.length != postorder.length) {
			return null;
		}
		HashMap<Integer, Integer> postMap = new HashMap<>();
		for (int i = 0; i < postorder.length; i++) {
			postMap.put(postorder[i], i);
		}
		return constructBT(preorder, 1, preorder.length-1, postorder, 0, postorder.length-1, postMap);
		
	}
	
	private TreeNode constructBT (int [] preorder, int ps, int pe, int [] postorder, int pos, int poe, HashMap<Integer, Integer> postMap) {
		if(ps>pe || pos>poe) {
			return null;
		}
		TreeNode node = new TreeNode(preorder[ps]);
		int rootIndex = postMap.get(preorder[ps]);
		int numsLeft = poe-rootIndex;
		node.left = constructBT(preorder, ps+1, pe, postorder, pos, poe, postMap);
		return null;
	}

}
