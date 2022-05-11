
public class NdigitNumbe {

	public static void main(String[] args) {
		NdigitNumbe ndigitNumbe = new NdigitNumbe();
		System.out.println(ndigitNumbe.solve(75,22));
	}
	
	public int solve(int A, int B) {
		int sum = 0;
		int [][] dp = new int [A+1][B+1];
		for (int i = 0; i <= A; i++) {
			for (int j = 0; j <= B; j++) {
				dp[i][j] = -1;
			}
		}
		int mod = (int) (Math.pow(10, 9) + 7);
		for (int i = 1; i <= B; i++) {
			sum = sum + findSum(A-1, B-i, dp);
			sum=sum%mod;
		}	
		return sum;
    }
	
	private int findSum (int i, int j, int [][] dp) {
		int mod = (int) (Math.pow(10, 9) + 7);
		if(j<0)
			return 0;
		if(i==0&&j==0) {
			return 1;			
		} 
		if(i==0)
			return 0;
		if(dp[i][j] != -1) {
			return dp[i][j];
		}
		int ans = 0;
		for (int k = 0; k <= j; k++) {
			ans = ans + findSum(i-1, j-k, dp);
			ans=ans%mod;
		}
		return dp[i][j] = ans;
	}
}
