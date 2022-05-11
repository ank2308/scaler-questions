
public class MaxProductInSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {3,2,0,0,4,-1,-2};
		MaxProductInSubArray array = new MaxProductInSubArray();
		System.out.println(array.maxProduct(A));
	}
	
	public int maxProduct(final int[] A) {
		
		int ans = A[0];
		int min = A[0];
		int max = A[0];
		for (int i = 1; i < A.length; i++) {
			int tempMin = Math.min(A[i], A[i] * min);
			int tempMax = Math.max(A[i], A[i] * min);
			min = Math.min(tempMin, A[i] * max);
			max = Math.max(tempMax, A[i] * max);
			ans = Math.max(ans, max);
		}
		return ans;
    }
	
	

}
