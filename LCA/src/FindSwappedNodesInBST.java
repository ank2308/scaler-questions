import java.util.Stack;

public class FindSwappedNodesInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode A = new TreeNode(9);
		A.left = new TreeNode(6);
		A.right = new TreeNode(14);
		A.left.left = new TreeNode(4);
		A.left.right = new TreeNode(5);
		A.right.left = new TreeNode(11);
		A.right.right = new TreeNode(18);
		FindSwappedNodesInBST bst = new FindSwappedNodesInBST();
		bst.recoverTree(A);
	}
	
	TreeNode first, middle, last, prev;
	
	public int[] recoverTree(TreeNode A) {
		first = middle = last = prev = null;
		correctBSTUtil(A);
		int [] arr = new int[2];
		if(last == null) {
			last = middle;
		}
		arr[0] = Math.min(first.val, last.val);
		arr[1] = Math.max(first.val, last.val);
		return arr;
    }
	
	void correctBSTUtil( TreeNode root)
    {
        if( root != null )
        {
            // Recur for the left subtree
            correctBSTUtil( root.left);

            // If this node is smaller than
            // the previous node, it's 
            // violating the BST rule.
            if (prev != null && root.val <
                                prev.val)
            {
                // If this is first violation,
                // mark these two nodes as
                // 'first' and 'middle'
                if (first == null)
                {
                    first = prev;
                    middle = root;
                }

                // If this is second violation,
                // mark this node as last
                else
                    last = root;
            }

            // Mark this node as previous
            prev = root;

            // Recur for the right subtree
            correctBSTUtil( root.right);
        }
    }
}	
