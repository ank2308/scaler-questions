
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int solve(int A, int B) {
		int ans = (int) pow(A, B-2, B);
		return ans;
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
