import java.util.Arrays;

public class UniqueElements {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueElements mns = new UniqueElements();
		int [] A = {1, 1000000, 1000000, 100000000, 10000, 10000, 10000};
//		int [] A = {1, 2, 3, 5, 6, 13, 13, 15, 16, 17, 13, 13, 15, 17, 17, 17, 17, 17, 19, 19};
//		int [] A = {1, 2, 2, 3, 3, 5, 6, 6, 14, 17, 18, 17, 18, 15, 15, 17, 19, 14, 19, 18};
		System.out.println(mns.solve(A));
	}
	
	public int solve(int[] A) {
		Arrays.sort(A);
		int count = 0;
		for (int i = 1; i < A.length; i++) {
			if(A[i]==A[i-1] || A[i]<A[i-1]) {
				count = count + ((A[i-1]+1)-A[i]);
				A[i] = A[i-1]+1;
			}
		}
		return count;
    }
}
