
public class CoinSumInfinite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {2, 5, 3, 6};
		CoinSumInfinite coinSumInfinite = new CoinSumInfinite();
		System.out.println(coinSumInfinite.coinchange2(A, 10));
	}
	
	public int coinchange2(int[] A, int B) {
		return findSum(A, 0, B);
	}

	private int findSum(int [] A, int i, int B) {
		if(B>0 && i>A.length-1) {
			return 0;
		}
		if(B==0) {
			return 1;
		}
		if(B<0) {
			return 0;
		}
		int ways = findSum(A, i, B-A[i]) + findSum(A, i+1, B);
		return ways;
	}
}
