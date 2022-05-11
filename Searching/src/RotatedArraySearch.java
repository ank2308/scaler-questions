
public class RotatedArraySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {1, 7, 67, 133, 178} ;
		RotatedArraySearch arraySearch = new RotatedArraySearch();
		System.out.println(arraySearch.search(A, 1));
	}
	
	public int search(final int[] A, int B) {
		
		int pivot = findPivot(A);
		
		if(pivot == -1) {
			return binarySearch(A, 0, A.length-1, B);
		}
		if(B==A[pivot]) {
			return pivot;
		} else if(B>=A[0]) {
			return binarySearch(A, 0, pivot-1, B);
		} else {
			return binarySearch(A, pivot+1, A.length-1, B);
		}
		
    }
	
	private int binarySearch(int[] A, int low, int high, int B) {
		
		
		while(low<=high) {
			int mid = low + (high-low)/2;
			if(B<A[mid]) {
				high = mid-1;
			} else if(B>A[mid]) {
				low = mid+1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	
	private int findPivot(int [] A) {
		int low = 0;
		int high = A.length-1;
		while (low <= high ) {
			int mid = low +(high-low) / 2;
			if (mid < high && A[mid] > A[mid+1]) {
				return mid;
			}
			if (mid>low && A[mid]<A[mid-1]) {
				return mid-1;
			}
			if (A[mid]<A[low]) {
				high = mid-1;
			} else {
				low = mid+1;
			}			
		}
		return -1;
	}

}
