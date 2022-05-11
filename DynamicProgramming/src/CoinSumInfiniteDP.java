
public class CoinSumInfiniteDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {2, 5, 3, 6};
		CoinSumInfiniteDP coinSumInfinite = new CoinSumInfiniteDP();
		System.out.println(coinSumInfinite.coinchange2(A, 10));
	}
	
	public int coinchange2(int[] A, int B) {
		int mod = (int) (Math.pow(10, 6) + 7);
		int [][] dp = new int [A.length+1][B+1];
		for(int i = 0; i < A.length+1 ; i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i < A.length+1; i++) {
			for (int j = 1; j < B+1; j++) {
				if(A[i-1] <= j) {
					dp[i][j] = (dp[i-1][j] + dp[i][j-A[i-1]]) % mod;
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[A.length][B];
	}
}
