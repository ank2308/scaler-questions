import java.util.Arrays;

public class MinAbsDiff {
	
	public static void main(String[] args) {
		MinAbsDiff mdf = new MinAbsDiff();
		int [] A = {1,2,3,4,5};
		System.out.println(mdf.solve(A));
	}
	
	public int solve(int[] A) {
		Arrays.sort(A);
		int min=Integer.MAX_VALUE;
		for (int i = 0; i < A.length-1; i++) {
			int diff = Math.abs(A[i+1] - A[i]); 
			if(diff < min) {
				min=diff;
			}
		}
		return min;
    }

}
