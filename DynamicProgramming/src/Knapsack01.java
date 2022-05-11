
public class Knapsack01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {359, 963, 465, 706, 146, 282, 828, 962, 492};
		int [] B = {96, 43, 28, 37, 92, 5, 3, 54, 93};
		int C = 383;
		Knapsack01 kp = new Knapsack01();
		System.out.println(kp.solve(A, B, C));
	}
	
	public int solve(int[] A, int[] B, int C) {
        int len1  = A.length;
        
        int [][] dp = new int [len1+1][C+1];
        for(int i = 0;i<=len1;i++){
            dp[i][0] = 0;
        }
        for(int i = 0;i<=C;i++){
            dp[0][i] = 0;
        }
        for (int i = 1; i < len1+1; i++) {
			for (int j = 1; j < C+1; j++) {
				if(B[i-1]<=j) {
					dp[i][j] = Math.max((A[i-1] + dp[i-1][j-B[i-1]]) , dp[i-1][j-B[i-1]]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
        return dp[len1][C];
    }

}
