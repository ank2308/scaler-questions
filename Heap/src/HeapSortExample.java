import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HeapSortExample {

	public static void main (String [] args) {
		int arr[] = { 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };
		HeapSortExample example = new HeapSortExample();
//		example.constructMaxHeap(arr, arr.length);
		
		example.constructMinHeap(arr, arr.length);
		System.out.println(Arrays.asList(arr));
//		example.insertIntoMinHeap(arr, arr.length, -2);
		example.deleteRootfromMinHeap(arr, arr.length);
	}
	
	private void constructMaxHeap (int [] numbers, int n) {
		int startIdx = (n/2)-1;
		for (int i = startIdx; i >=0; i--) {
			heapifyMax(numbers, n, i);
		}
	}
	
	private void heapifyMax (int [] arr, int n, int root) {
		int largest = root;
		int l = 2*root+1;
		int r = 2*root+2;
		if(l<n && arr[l] > arr[largest]) {
			largest = l;
		}
		if(r<n && arr[r] > arr[largest]) {
			largest = r;
		}
		if(largest != root) {
			int swap = arr[root];
			arr[root] = arr[largest];
			arr[largest] = swap;
			
			heapifyMax(arr, n, largest);
		}
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
}
