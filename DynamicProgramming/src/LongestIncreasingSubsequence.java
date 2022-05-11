
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {30, 92, 22, 48, 52, 64, 92, 50, 85, 38, 97, 15, 14, 75, 59, 46, 74, 6, 95, 67, 86, 88, 25, 49, 67, 69, 50, 99, 83, 49, 60, 6, 90, 1, 50, 41, 57, 18, 36, 5, 44, 100, 23, 33, 52, 11, 46, 49, 34, 27, 77, 57, 93, 82, 38, 95, 6, 51, 100, 32, 11, 26, 50, 3, 55, 39, 84, 54, 44, 75, 76, 51, 21, 40, 28, 50, 30, 6, 84, 58, 76, 42, 35, 49, 98, 49, 13, 101, 3, 1, 60, 48, 99, 70};
		LongestIncreasingSubsequence increasingSubsequence = new LongestIncreasingSubsequence();
		System.out.println(increasingSubsequence.lis(A));
	}
	public int lis(final int[] A) {
		int [] dp = new int [A.length];
		dp[0] = 0;
		int len = 0;
		for (int i = 1; i < A.length; i++) {
			if(A[i] < A[dp[0]]) {
				dp[0] = i;
			} else if (A[dp[len]] < A[i]) {
				len++;
				dp[len] = i;
				
			} else {
				int index = ceilIndex(A, dp, len, A[i]);
				dp[index] = i;
			}
		}
		return len+1;
    }
	
	private int ceilIndex (int [] A, int [] dp, int len, int s) {
		int start = 0;
		int end = len;
		int mid ;
		while(start<=end) {
			mid = (start + end)/2;
			if(mid<len && A[dp[mid]] <s && s<= A[dp[mid+1]]) {
				return mid+1;
			}else if(A[dp[mid]] < s) {
				start = mid+1;
			} else {
				end = mid-1;
			}
		}
		return 0;
	}
}
