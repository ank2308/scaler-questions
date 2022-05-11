
public class RotatedSortedArraySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int search(final int[] A, int B) {
		
    }
	
	public int searchElement(int[] A, int B, boolean secondHalf, int start, int end ) {
		
		
		
		int mid = (start + end)/2;
		if(A[mid] == B) {
			return mid;
		}
		if(A[mid] > A[0] && secondHalf ) {
			return searchElement(A, B, secondHalf, mid+1, end);
		} else {
			
		}
	}

}
