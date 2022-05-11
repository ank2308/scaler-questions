
public class CheckBSTWithOneChild {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {1,2,6,4,3};
		CheckBSTWithOneChild bstWithOneChild = new CheckBSTWithOneChild();
		System.out.println(bstWithOneChild.solve(A));
	}
	public String solve(int[] A) {
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		int root = A[0];	
		boolean isBST = true;
		for (int i = 1; i < A.length; i++) {
			if(A[i] > root) {
				min = root;
			} else {
				max = root;
			}
			if(A[i]<min || A[i]>max) {
				isBST = false;
				break;
			} else {
				root = A[i];				
			}
		}
		if(isBST) {
			return "YES";
		} else {
			return "NO";
		}
    }
}
