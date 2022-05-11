
public class ProductOfThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {11, 5, 6, 2, 8, 10};
		ProductOfThree pot = new ProductOfThree();
		pot.solve(A);
	}
	
	public int[] solve(int[] A) {
		int [] minHeap = new int [3];
		int [] ans = new int [A.length];
		int sum = 1;
		for (int i = 0; i < A.length; i++) {
			if(i<=2) {
				minHeap = insertIntoMinHeap(minHeap, i, A[i]);
				sum = sum * A[i];
			} else if(i>2 && A[i]>minHeap[0]) {
				sum = sum / minHeap[0];
				sum = sum * A[i];
				deleteRootfromMinHeap(minHeap, minHeap.length);
				minHeap = insertIntoMinHeap(minHeap, minHeap.length-1, A[i]);
			} 			
			if(i>1) {
				ans[i] = sum;
			} else {
				ans[i] = -1;
			}
		}
		return ans;
    }
	
	private int[] insertIntoMinHeap (int [] arr, int n, int val) {
		int [] ans = new int [n+1];
		for (int i = 0; i < n; i++) {
			ans[i] = arr[i];
		}
		ans[ans.length-1] = val;
		int i = ans.length-1;
		while(val < ans[(i-1)/2]) {
			int swap = ans[(i-1)/2];
			ans[(i-1)/2] = ans[i];
			ans[i] = swap;
			i=(i-1)/2;
		}
		return ans;
	}
	private int[] deleteRootfromMinHeap(int [] arr, int n) {
		int [] ans = new int [n-1];
		int swap = arr[0];
		arr[0] = arr[n-1];
		arr[n-1] = swap;
		heapifyMin(arr, n-1, 0);
		for (int i = 0; i < n-1; i++) {
			ans[i] = arr[i];
		}
		return ans;
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
