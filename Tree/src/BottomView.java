import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.Stack;

public class BottomView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode A = new TreeNode(1);
		A.left = new TreeNode(2);
		A.right = new TreeNode(3);
		A.left.left = new TreeNode(4);
		A.left.right = new TreeNode(5);
		A.right.left = new TreeNode(6);
		A.right.right = new TreeNode(7);
		
		
		BottomView orderTraversal = new BottomView();
		int [] arr = orderTraversal.solve(A);
		System.out.println(Arrays.asList(arr));
	}
	

	int minDist = 0;
	int maxDist = 0;
	public int[] solve(TreeNode A) {
		HashMap<Integer, TreeNode> bottomview = new HashMap<>();
		buildTopView(A, 0, bottomview);
		int len = maxDist - minDist + 1;
		int [] ans = new int[len];
		for (int i = 0; i < len; i++) {
			ans[i] = bottomview.get(minDist).val;
			minDist++;
		}
		return ans;
	}
	
	private void buildTopView (TreeNode A, int dist, HashMap<Integer, TreeNode> hashMap) {
		hashMap.put(dist, A);
		minDist = Math.min(minDist, dist);
		maxDist = Math.max(maxDist, dist);
		if(A.left!=null) {
			buildTopView(A.left, dist-1, hashMap);
		} 
		if(A.right!=null) {
			buildTopView(A.right, dist+1, hashMap);
		}
	}

}
