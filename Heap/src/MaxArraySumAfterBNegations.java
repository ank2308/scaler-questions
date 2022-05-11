
public class MaxArraySumAfterBNegations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {24, -68, -29, -9, 84};
		MaxArraySumAfterBNegations afterBNegations = new MaxArraySumAfterBNegations();
		afterBNegations.solve(A, 4);
	}
	
	public int solve(int[] A, int B) {	
		int n = A.length;
		constructMinHeap(A, n);
		while(B>0) {
			deleteRootfromMinHeap(A, n);
			int i = A.length-1;
			int val = A[n-1];
			while(val < A[(i-1)/2]) {
				int swap = A[(i-1)/2];
				A[(i-1)/2] = A[i];
				A[i] = swap;
				i=(i-1)/2;
			}
			B--;
		}
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum = sum + A[i];
		}
		return sum;
    }
	
	private void constructMinHeap (int [] numbers, int n) {
		int startIdx = (n/2)-1;
		for (int i = startIdx; i >=0; i--) {
			heapifyMin(numbers, n, i);
		}
	}
	
	private void heapifyMin (int [] arr, int n, int root) {
		int smallest = root;
		int l = 2*root+1;
		int r = 2*root+2;
		if(l<n && arr[l] < arr[smallest]) {
			smallest = l;
		}
		if(r<n && arr[r] < arr[smallest]) {
			smallest = r;
		}
		if(smallest != root) {
			int swap = arr[root];
			arr[root] = arr[smallest];
			arr[smallest] = swap;
			
			heapifyMin(arr, n, smallest);
		}
	}
	
	private void deleteRootfromMinHeap(int [] arr, int n) {
		int swap = arr[0];
		arr[0] = arr[n-1];
		arr[n-1] = swap;
		heapifyMin(arr, n-1, 0);
		int val = arr[n-1] * -1;
		arr[n-1] = val;
	}

}
