
public class FindPeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindPeakElement element = new FindPeakElement();
		int [] A = {5,4,6,7,9};
		System.out.println(element.findPeakElement(A));
	}
	public int findPeakElement(int[] A) {
		if(A.length == 1)
			return 0;
		if(A.length == 2) {
			return A[0] > A[1] ? 0 : 1;
		}
		return peakElement(A, 0, A.length-1);
	}
	
	public int peakElement(int []A,int start, int end) {
		int mid = (start + end)/2;
		if(start == end) {
			return start;
		}
		if(mid == 0) {
			if(A[0] > A[1]) {
				return 0;
			} else {
				return 1;
			}
		}
		if(A[mid] < A[mid-1]) {
			return peakElement(A, start, mid-1);
		} else if(A[mid] < A[mid+1]) {
			return peakElement(A, mid+1, end);
		} else {
			return mid;
		}
	}
}
