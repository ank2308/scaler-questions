
public class Kthsmallest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kthsmallest sm = new Kthsmallest();
		int [] A = {2, 1, 4, 3, 2};
		System.out.println(sm.kthsmallest(A, 3));
	}
	
	public int kthsmallest(final int[] A, int B) {
		int temp = A[0];
		int ans = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = i+1; j < A.length; j++) {
				if(A[j]<A[i]) {
					temp = A[i];
					A[i] = A[j];
					A[j] = temp;
				}				
			}
			if(i == B-1) {
				ans =  A[i];
			}
		}
		return ans;
    }

}
