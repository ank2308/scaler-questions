import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class LCAOfTwoNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode A = new TreeNode(1) ;
		A.left = new TreeNode(2);
		A.right = new TreeNode(3);
		A.left.left = new TreeNode(4);
		A.left.right = new TreeNode(5);
		A.right.left = new TreeNode(8);
		A.right.right = new TreeNode(21);
		LCAOfTwoNodes lcaOfTwoNodes = new LCAOfTwoNodes();
		System.out.println(lcaOfTwoNodes.lca(A, 3, 21));
	}
	
	private List<Integer> path1 = new ArrayList<>();
    private List<Integer> path2 = new ArrayList<>();
	
	public int lca(TreeNode A, int B, int C) {
		findPath(A, B, path1);		
		findPath(A, C, path2);
		
		int ans = -1;
		if(path1 == null || path2 == null) {
			return -1;
		} else {
			int length = Math.min(path1.size(), path2.size());
			for (int i = 0; i < length; i++) {
				if(path1.get(i) != path2.get(i)) {
					return ans;
				} else {
					ans = path2.get(i);
				}
			}
		}
		return ans;
    }
	
	public TreeNode findLCA(TreeNode A, int B, int C) {
        if(A == null || A.val==B || A.val==C) {
            return A;
        }
        TreeNode left = findLCA(A.left, B, C);
        TreeNode right = findLCA(A.right, B, C);
        if(left == null ){
            return right;
        } else if (right == null){
            return left;
        } else {
            return A;
        }
    }
	
	private boolean findPath (TreeNode root, int n, List<Integer> path) {
		// base case
        if (root == null) {
            return false;
        }
        
        // Store this node . The node will be removed if
        // not in path from root to n.
        path.add(root.val);

        if (root.val == n) {
            return true;
        }

        if (root.left != null && findPath(root.left, n, path)) {
            return true;
        }

        if (root.right != null && findPath(root.right, n, path)) {
            return true;
        }

        // If not present in subtree rooted with root, remove root from
        // path[] and return false
        path.remove(path.size()-1);

        return false;
	}

}
