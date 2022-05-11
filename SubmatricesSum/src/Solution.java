
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] A = {{1,1},{1,1}};
		Solution s = new Solution();
		System.out.println(s.solve(A));
	}
	
	public int solve(int[][] A) {
		int sum=0;
		int len = A.length;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				sum = sum + (A[i][j]*(i+1)*(j+1)*(len-i)*(len-j));
			}
		}
		return sum;
    }
}
