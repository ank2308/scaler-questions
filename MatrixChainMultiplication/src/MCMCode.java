
public class MCMCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {40, 20, 30, 10, 30};
		MCMCode code = new MCMCode();
		System.out.println(code.solve(A));
	}
	
	int [][] dp = new int [1001][1001];

    public int solve(int[] A) {
    	for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp.length; j++) {
				dp[i][j] = -1;
			}
		}
    	return calculateMCM(A, 1, A.length-1);

    }

    private int calculateMCM (int [] A, int i, int j){
        if(i>=j)
            return 0;
        int min = Integer.MAX_VALUE;
        if(dp[i][j]!=-1) {
        	return dp[i][j];
        }
        for (int k = i; k < j; k++) {
			int tempAns = calculateMCM(A, i, k) + calculateMCM(A, k+1, j) + (A[i-1]*A[k]*A[j]);
			if(tempAns < min) {
				min = tempAns;
			}
		}
        dp[i][j] = min;
        return dp[i][j];
    }

}
