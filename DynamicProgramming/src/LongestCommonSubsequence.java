
public class LongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "abbcdgf";
		String B = "bbadcgf";
		LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
		System.out.println(longestCommonSubsequence.solve(A, B));
	}
	
	public int solve(String A, String B) {
		char[] Ar = A.toCharArray();
		char[] Br = B.toCharArray();
		int m = Ar.length;
		int n = Br.length;
		int [][] dp = new int [m+1][n+1];
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < n+1; j++) {
				dp[i][j] = 0;
			}
		}
		for (int i = 1; i < m+1; i++) {
			dp[i][0] = 0;
		}
		for (int i = 1; i < m+1; i++) {
			for (int j = 1; j < n+1; j++) {
				if(Ar[i-1] == Br[j-1]) {
					dp[i][j] = 1+dp[i-1][j-1];
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[n][m];
    }

}
