import java.util.Arrays;

public class BurMaxMobilePhone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {23,36,58,59};
		int [] B = {3,207,62,654,939,680,760};
		BurMaxMobilePhone maxMobilePhone = new BurMaxMobilePhone();
		System.out.println(Arrays.asList(maxMobilePhone.solve(A, B)));
	}
	public int[] solve(int[]A, int[] B) {
		int [] prefixSum = new int[A.length];
		prefixSum[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			prefixSum[i] = A[i] + prefixSum[i-1];
		}
		int [] ans = new int[B.length];
		for (int i = 0; i < B.length; i++) {
			ans[i] = findMobileCount(prefixSum, B[i], 0, prefixSum.length-1, 0);
		}
		return ans;
	}
	
	private int findMobileCount (int [] prefixSum, int val, int start, int end, int sum) {
		if(start>end) {
			return sum;
		}
		int mid = (start+end)/2;
		if(val == prefixSum[mid]) {
			return sum = mid+1;			
		}
		if(val>prefixSum[mid]) {
			sum = mid+1;
			sum = findMobileCount (prefixSum, val, mid+1, end, sum);
		} else {
			sum = findMobileCount (prefixSum, val, start, mid-1, sum);
		}
		return sum;
	}
}
