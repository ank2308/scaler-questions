import java.util.Arrays;

public class InversionCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {28, 18, 44, 49, 41, 14};
		InversionCount mr = new InversionCount();
		System.out.println(mr.solve(A));
	}
	int count = 0;
	int mod = (int) (Math.pow(10, 9) + 7);
	
	public int solve(int[] A) {
		sort(A,0,A.length-1);
		return count;
    }
	
	void sort(int arr[], int l, int r)
    {
        if (l < r) {
            int m =l+ (r-l)/2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

	void merge(int arr[], int l, int m, int r)
    {
		
		
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];
  
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                count=((count%mod)+m-(i+l)+1)%mod;
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
