
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s  = new Solution();
		System.out.println(s.solve(4,28));
		int mod = (int) (Math.pow(10, 9) + 7);
		System.out.println(142708978%mod);
		System.out.println(546197446);
	}
	
	public int solve(int A, int B) {
		int mod = (int) (Math.pow(10, 9) + 7);
		long fact = 1;
		for(int i=1;i<=B;i++) {
			fact = (fact * i ) % (mod -1);
		}
		System.out.println(fact);
		return (int) pow(A,fact,mod);
    }
	
	public static long pow(long A, long B, int M) {
		if(B==0) {
			return 1;
		}
		if(B%2 == 0) {
			return pow((A*A) % M, B/2, M);
		} else {
			return (A * pow((A*A) % M, (B-1)/2, M)) % M;
		}
	}

}
