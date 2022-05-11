import java.util.HashSet;

public class EqualTreePartition {
	
	public static void main(String [] args) {
		TreeNode A = new TreeNode(5) ;
		A.left = new TreeNode(3);
		A.left.left = new TreeNode(4);
		A.left.right = new TreeNode(6);
		A.right = new TreeNode(7);
		A.right.left = new TreeNode(5);
		A.right.right = new TreeNode(5);
		EqualTreePartition equalTreePartition = new EqualTreePartition();
		System.out.println(equalTreePartition.solve(A));
	}
	
	private HashSet<Integer> sumSet = new HashSet<>();
	private int maxSum = 0;
	
	public int solve(TreeNode A) {
		checkPartiion(A, 0);
		if(maxSum %2 == 0) {
			if(sumSet.contains(maxSum /2)){
				return 1;
			}
		}
		return 0;
    }
	private class Info {
		int sumOfTree;
		public Info(int sumOfTree) {
			this.sumOfTree = sumOfTree;
		}
	}
	
	private Info checkPartiion (TreeNode A, int sum) {
		if(A==null) {
			return new Info(sum);
		}
		
		Info LInfo = checkPartiion(A.left, sum);
		Info RInfo = checkPartiion(A.right, sum);
		sum = LInfo.sumOfTree + RInfo.sumOfTree + A.val;
		sumSet.add(sum);
		maxSum = sum;
		return new Info(sum);
	}
	
}
