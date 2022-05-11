
public class FindUniquePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] A = {{1,0,1,0},{1,1,0,1},{1,1,1,1},{0,0,0,0},{0,1,1,1},{0,0,1,1},{1,0,0,1}};
		FindUniquePath findUniquePath = new FindUniquePath();
		System.out.println(findUniquePath.uniquePathsWithObstacles(A));
	}
	
	public int uniquePathsWithObstacles(int[][] A) {
		int row = A.length;
		int column = A[0].length;
		int [][] dp = new int [row][column];
		boolean flag = false;
		for (int i = 0; i < column; i++) {
			if(flag || A[0][i] == 1) {
				flag = true;
				dp[0][i] = 0;
			} else {
				dp[0][i] = 1;
			}
		}
		flag = false;
		for (int i = 0; i < row; i++) {
			if(flag || A[i][0] == 1) {
				flag = true;
				dp[i][0] = 0;
			} else {
				dp[i][0] = 1;
			}
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < column; j++) {
				if(A[i][j] == 0) {
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
				} else {
					dp[i][j] = 0;
				}
			}
		}
		return dp[row-1][column-1];
    }

}
