public class CountSubarrays {
	
	public static void main(String [] args) {
		CountSubarrays cbs = new CountSubarrays();
		int [] A = {93, 9, 12, 32, 97, 75, 32, 77, 40, 79, 61, 42, 57, 19, 64, 16, 86, 47, 41, 67, 76, 63, 24, 10, 25, 96, 1, 30, 73, 91, 70, 65, 53, 75, 5, 19, 65, 6, 96, 33, 73, 55, 4, 90, 72, 83, 54, 78, 67, 56, 8, 70, 43, 63};
		System.out.println(cbs.solve(A));
	}
	
	public int solve(int[] A) {
		int i=0,j=1;
		int count = 0;
		if(A.length > 0) {
			count = A.length;
		}
		int max = A[0];
		for (int k = 1; k < A.length; k++) {
			max = Math.max(max, A[k]);
		}
		int [] freq = new int [max+1];
		freq[A[0]]++;
		while(i<A.length && j<A.length) {			
			if(A[i] != A[j] && freq[A[j]] == 0) {
				count = count + (j-i);
				freq[A[j]]++;
				j++;
			} else {
				i++;
			}
			if(i==j) {
				j++;
			}
		}
		return count;
    }
}
