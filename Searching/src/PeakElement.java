
public class PeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {1,2,3,4,5};
		PeakElement pk = new PeakElement();
		System.out.println(pk.solve(A));
	}
	
	public int solve(int[] A) {
		if(A.length>1 && (A[0] > A[1])) {
			return A[0];
		}
		if(A.length>1 && (A[A.length-1] > A[A.length - 2])) {
			return A[A.length-1];
		}
		return peakElement(A, 0, A.length-1);
    }
	
	public int peakElement(int []A,int start, int end) {
		
		if(start==end) {
			if(A.length > 1 && A[start] > A[start -1]) {
				return A[start];
			} else {
				return A[0];
			}
		}
		if(A.length == 2) {
			return Math.max(A[start], A[end]);
		}
		int mid = (start + end )/2;
		if(A[mid] < A[mid-1]) {
			return peakElement(A, start, mid-1);
		} else if(A[mid] < A[mid+1]) {
			return peakElement(A, mid+1, end);
		} else {
			return A[mid];
		}
	}

}
