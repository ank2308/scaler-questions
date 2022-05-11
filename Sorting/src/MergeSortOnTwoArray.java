
public class MergeSortOnTwoArray {
	
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
  
    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
  
    // Driver code
    public static void main(String args[])
    {
        int arr[] = {3,2,6,4,1};
        int arr1[] = {9,8,7,6,5};
  
        MergeSortOnTwoArray ob = new MergeSortOnTwoArray();
        ob.sort(arr, arr1, 0, arr.length - 1);
        ob.printArray(arr);
        ob.printArray(arr1);
        int occ = 1;
        int occIndex = 0;
        for(int i =1;i<arr.length;i++) {
        	if(arr[i]>=arr1[occIndex]) {
        		occIndex=i;
        		occ++;
        	}
        }
        
    }
}
