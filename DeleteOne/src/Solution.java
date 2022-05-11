
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sln = new Solution();
		int [] A = {7, 21};
		System.out.println(sln.solve(A));
	}
	
	public int solve(int[] A) {
		int [] gcd = new int [A.length];
		int [] gcdinverse = new int [A.length];
		gcd[0]=A[0];
		gcdinverse[A.length-1] = A[A.length-1];
		for (int i = 1; i < A.length; i++) {
			gcd[i] = gcd(gcd[i-1],A[i]);
			gcdinverse[A.length-1-i] = gcd(gcdinverse[A.length-i],A[A.length-1-i]);
		}
		int mingcd = 0;
		for (int i = 1; i < gcdinverse.length; i++) {
			if(gcd[i] < gcd[i-1]) {
				mingcd = i;
			}
		}
		if(mingcd == 0) {
			return gcdinverse[1];
		}
		return gcd(gcd[mingcd - 1], gcdinverse[mingcd + 1]);
    }
	
	public static int gcd(int A, int B) {
		if(B == 0) {
			return A;
		}
		return gcd(B,A%B);
    }

}
