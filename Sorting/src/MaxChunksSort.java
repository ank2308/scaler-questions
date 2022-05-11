import java.util.Arrays;

public class MaxChunksSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {2,1,0,3};
		MaxChunksSort ms = new MaxChunksSort();
		System.out.println(ms.solve(A));
	}
	
	public int solve(int[] A) {
		int count = 0;
		int max=0;
		for (int i = 0; i < A.length; i++) {
			max = Math.max(max, A[i]);
			if(max == i) {
				count = count+1;
			}
		}
		return count;
    }

}
