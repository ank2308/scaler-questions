import java.util.Collections;
import java.util.PriorityQueue;

public class FreeCars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {6, 8, 5, 4, 2, 1, 6, 4, 2, 8, 5, 4, 4, 8, 8, 5, 3, 4, 4, 5, 8, 5, 5, 7, 2, 4, 5, 2, 6};
		int [] B = {11, 10, 8, 10, 5, 7, 5, 9, 8, 7, 11, 5, 7, 4, 7, 9, 8, 5, 5, 5, 8, 11, 8, 4, 4, 2, 9, 6, 6};
		FreeCars fc = new FreeCars();
		System.out.println(fc.solve(A, B));
	}
	
	public int solve(int[] A, int[] B) {
		int maxLength = 0;
		for (int i = 0; i < B.length; i++) {
			if(A[i]>maxLength) {
				maxLength = A[i];
			}
		}		
		sort(B, A, 0, A.length-1);
		int sum = 0;
		int carsOcc = 0;
		PriorityQueue<Integer> minBuyCars = new PriorityQueue<>();
		for (int i = 0; i <B.length; i++) {
			if(carsOcc < A[i]) {				
                minBuyCars.add(B[i]);
                carsOcc++;				
			} else {
				while(i<B.length && carsOcc == A[i]) {
					if(minBuyCars.peek()<B[i]) {
						minBuyCars.poll();
						minBuyCars.add(B[i]);
						i++;
					} else {
						i++;
						break;
					}
				}
				i--;
			}
		}
        int mod = (int)(Math.pow(10,9)+7);
		while(!minBuyCars.isEmpty()) {
			sum = (sum + minBuyCars.poll())/mod;
		}
		return sum;
    }	
	
	void merge(int arr[], int arr1[], int start, int mid, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = mid - start + 1;
        int n2 = r - mid;
  
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
        int L1[] = new int[n1];
        int R1[] = new int[n2];
  
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[start + i];
            L1[i] = arr1[start+i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[mid + 1 + j];
            R1[j] = arr1[mid+1+j];
        }
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
  
        // Initial index of merged subarray array
        int k = start;
        while (i < n1 && j < n2) {
            if (L1[i] <= R1[j]) {
                arr[k] = L[i];
                arr1[k] = L1[i];
                i++;
            }
            else {
                arr[k] = R[j];
                arr1[k] = R1[j];
                j++;
            }
            k++;
        }
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            arr1[k] = L1[i];
            i++;
            k++;
        }
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            arr1[k] = R1[j];
            j++;
            k++;
        }
    }
  
    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int arr1[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
  
            // Sort first and second halves
            sort(arr, arr1, l, m);
            sort(arr, arr1, m + 1, r);
  
            // Merge the sorted halves
            merge(arr, arr1, l, m, r);
        }
    }
}
