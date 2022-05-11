import java.util.Arrays;

public class Merge2SortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {-4,-3,0};
		int [] B = {2};
		Merge2SortedArrays mr = new Merge2SortedArrays();
		System.out.println(Arrays.toString(mr.solve(A, B)));
	}
	public int[] solve(final int[] A, final int[] B) {
		int [] ans = new int [A.length + B.length];
		int index = 0;
		int i,j;
		for (i = 0, j=0; i < A.length && j<B.length;) {			
			if(A[i] < B[j]) {
				ans[index] = A[i];
				i++;
			} else {
				ans[index] = B[j];
				j++;
			}
			index++;
		}
		while(i<A.length) {
			ans[index] = A[i];
			index++;
			i++;
		}
		while(j<B.length) {
			ans[index] = B[j];
			index++;
			j++;
		}
		return ans;
    }

}
