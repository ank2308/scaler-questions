
public class Solution {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {17, 100, 11};
		Solution sln = new Solution();
		System.out.println(sln.solve(A));
	}
	public int solve(int[] A) {
		long sum = 0;
		int mod = (int) (Math.pow(10, 9) + 7);
		int val;
		long temp;
		int [] freq = new int[1001];
		for (int i = 0; i < A.length; i++) {
			freq[A[i]] =  freq[A[i]] + 1;
		}
		for (int i = 1; i < freq.length; i++) {
			for (int j = 1; j < freq.length; j++) {
				val = i%j;
				temp = freq[i] * freq[j] * val;
				sum = (sum%mod + temp%mod)%mod;
			}
		}
		return (int)sum;
	}
}
