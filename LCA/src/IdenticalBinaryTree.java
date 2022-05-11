import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IdenticalBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode B = new TreeNode(3) ;
		B.left = new TreeNode(9);
		B.right = new TreeNode(20);
		B.right.left = new TreeNode(15);
		B.right.left.left = new TreeNode(15);
		B.right.right = new TreeNode(7);
		
		TreeNode A = new TreeNode(3) ;
		A.left = new TreeNode(9);
		A.right = new TreeNode(20);
		A.right.left = new TreeNode(15);
		A.right.left.left = new TreeNode(15);
		A.right.right = new TreeNode(7);
		
		IdenticalBinaryTree identicalBinaryTree = new IdenticalBinaryTree();
		System.out.println(identicalBinaryTree.checBSTareSame(null, null));

	}
	public int isSameTree(TreeNode A, TreeNode B) {
		if(checBSTareSame(A, B)) {
			return 1;
		} else {
			return 0;
		}
    }
	
	public boolean checBSTareSame(TreeNode A, TreeNode B) {
		Queue<TreeNode> listTreeA = new LinkedList<TreeNode>();
		Queue<TreeNode> listTreeB = new LinkedList<TreeNode>();
		if(A==null && B==null) {
			return true;
		}
		listTreeA.add(A);
		listTreeB.add(B);
		boolean flag = true;
		while(true) {
			if(listTreeA.isEmpty() || listTreeB.isEmpty()) {
				break;
			}
			int nodeCountA = listTreeA.size();
			int nodeCountB = listTreeB.size();
			if(nodeCountA != nodeCountB) {
				return false;				
			}
			while (nodeCountA > 0) {
				TreeNode nodeA = listTreeA.poll();
				TreeNode nodeB = listTreeB.poll();
				if(nodeA.val != nodeB.val) {
					return false;
				}
				if(nodeA.left!=null) {
					listTreeA.add(nodeA.left);
				}
				if(nodeA.right!=null) {
					listTreeA.add(nodeA.right);
				}
				if(nodeB.left!=null) {
					listTreeB.add(nodeB.left);
				}
				if(nodeB.right!=null) {
					listTreeB.add(nodeB.right);
				}
				nodeCountA--;
				nodeCountB--;
			}
		}
		if (listTreeA.size() != listTreeB.size()) {
			flag = false;
		}
		return flag;
    }

}
