
public class TieRopes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {5, 12, 16, 5, 12, 19, 4, 3, 18, 15, 16};
		TieRopes tr = new TieRopes();
		System.out.println(tr.solve(A));
	}
	
	public int solve(int[] A) {
		int sum = 0;
		
		constructMinHeap(A, A.length);		
		int n = A.length;
		for (int i = 0; i < A.length-1; i++) {			
			int minA = A[0];
			deleteRootfromMinHeap(A, n-i);
			int minB = A[0];
			deleteRootfromMinHeap(A, n-i-1);	
			int temp = minA + minB;
			sum = sum + temp;
			A = insertIntoMinHeap(A, n-i-2, temp);
		}
		return sum;
    }
	
	private int[] insertIntoMinHeap (int [] arr, int n, int val) {		
		arr[n] = val;
		while(val < arr[(n)/2]) {
			int swap;
			if(n<2 && val < arr[n]) {
				swap = arr[n];
				arr[n] = arr[n-1];
				arr[n-1] = swap;
			} else {
				swap = arr[(n-1)/2];
				arr[(n-1)/2] = arr[n];
				arr[n] = swap;
			}						
			n=(n-1)/2;
		}
		return arr;
	}
	
	private void constructMinHeap (int [] numbers, int n) {
		int startIdx = (n/2)-1;
		for (int i = startIdx; i >=0; i--) {
			heapifyMin(numbers, n, i);
		}
	}
	
	private void deleteRootfromMinHeap(int [] arr, int n) {
		int swap = arr[0];
		arr[0] = arr[n-1];
		arr[n-1] = swap;
		heapifyMin(arr, n-1, 0);
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
}
