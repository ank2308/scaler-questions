import java.util.ArrayList;
import java.util.HashMap;

public class TopViewOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode A = new TreeNode(3) ;
		A.left = new TreeNode(9);
		A.right = new TreeNode(20);
		A.left.left = new TreeNode(15);
		A.left.right = new TreeNode(5);
		A.right.right = new TreeNode(7);
		A.right.left = new TreeNode(8);
		TopViewOfBinaryTree topViewOfBinaryTree = new TopViewOfBinaryTree();
		System.out.println(topViewOfBinaryTree.solve(A));

	}
	public ArrayList<Integer> solve(TreeNode A) {
		ArrayList<Integer> ans = new ArrayList<>();
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		int min=0, max=0, temp=0;
		return buildTopView(A, ans, temp, min, max, hashMap);
    }
	private ArrayList<Integer> buildTopView (TreeNode A, ArrayList<Integer> ans, int dist, int mindist, int maxdist, HashMap<Integer, Integer> hashMap) {
		if(!hashMap.containsKey(dist) && A!=null) {
			hashMap.put(dist, A.val);
			ans.add(A.val);
			mindist = Math.min(mindist, dist);
			maxdist = Math.max(maxdist, dist);
		} else {
			return ans;
		}
		ans = buildTopView(A.left, ans, dist-1, mindist, maxdist, hashMap);
		ans = buildTopView(A.right, ans, dist+1, mindist, maxdist, hashMap);
		return ans;
	}
}
