
public class MinNumberOfSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinNumberOfSquares numberOfSquares = new MinNumberOfSquares();
		System.out.println(numberOfSquares.countMinSquares(12));
	}

	public int countMinSquares(int A) {
		int  [] dp = new int[A+1];
		for (int i = 0; i < dp.length; i++) {
			if(i==0) {
				dp[i] = 0;
			} else {
				dp[i] = -1;
			}
		}
		int ans = findMinSquare(A, dp);
		return ans;
    }
	
	private int findMinSquare (int n, int [] ar) {
		if(ar[n] == -1) {
			int an = Integer.MAX_VALUE;
			int limit = (int) Math.sqrt(n);
			for (int i = 1; i <= limit; i++) {
				an = Math.min(an, 1+findMinSquare((n-(i*i)), ar));				
			}
			ar[n] = an;
			return ar[n];
		} else {
			return ar[n];
		}
	}
}
