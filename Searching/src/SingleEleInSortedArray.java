
public class SingleEleInSortedArray {
	
	public static void main(String [] args) {
		int [] A = {0,1,1,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10};
		SingleEleInSortedArray se = new SingleEleInSortedArray();
		System.out.println(se.solve(A));
	}
	
	public int solve(int[] A) {
		return SFSA(A,0,A.length-1);
    }
	
	public int SFSA(int [] A, int start, int end) {
		int mid = (start + end) / 2;
		if((mid == A.length-1) && (A[mid] != A[mid-1])) {
			return A[mid];
		}
		if((mid == 0) && (A[mid] != A[mid+1])) {
			return A[mid];
		}
		if((mid != A.length-1) && (mid != 0) && (A[mid] != A[mid+1]) && (A[mid] != A[mid-1])) {
			return A[mid];
		}
		
		if(A[mid] == A[mid+1]) {
			if(mid%2 == 0) {
				return SFSA(A, mid+2, end);
			} else {
				return SFSA(A, start, mid-1);
			}			
		}
		if(A[mid] == A[mid-1]) {
			if(mid%2 == 0) {
				return SFSA(A,start,end-2);
				
			} else {
				return SFSA(A,mid+1,end);
			}
		}
		return 0;
	}

}
