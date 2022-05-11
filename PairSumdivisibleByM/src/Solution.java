public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {1,2,3,4,5};
		Solution sln = new Solution();
		System.out.println(sln.solve(A, 2));
	}
	public int solve(int[] A, int B) {
		long [] tempAr = new long [B];
		int ele;
		for (int i = 0; i < A.length; i++) {
			ele = (A[i] % B);
			tempAr[ele] = tempAr[ele] + 1;
		}
		long sum = 0;
		int mod = (int) (Math.pow(10, 9) + 7);
		for (int i = 0; i <= B/2; i++) {
			if (i ==0 ) {
				long tempSize = tempAr[0];
				sum = sum + ((tempSize*(tempSize - 1))/2);
			} else {
				if(B-i != i) {
					sum = (sum + (tempAr[i] * tempAr[B-i]))%mod;
				} else {
					sum = (sum + ((tempAr[i]*(tempAr[i] - 1))/2))%mod;
				}
			}			
		}
		return (int) (sum );
    }

}
