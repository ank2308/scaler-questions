import java.util.Arrays;

public class AllocateBooks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {73, 58, 30, 72, 44, 78, 23, 9} ;
		AllocateBooks allocateBooks = new AllocateBooks();
		System.out.println(allocateBooks.books(A, 5));
	}
	
	public int books(int[] A, int B) {
		int mod = (int) (Math.pow(10, 9) + 7);
		if(B>A.length) {
			return -1;
			
		}
		long sum = 0;
		int max = 0;
		for (int i : A) {
			max = Math.max(i, max);
			sum = sum + max;
		}
		long start = max;
		long end = sum;
		while (start <= end) {
			long mid = (start+end)/2;
			int req = 1;
			int tempSum = 0;
			for (int i : A) {
				tempSum = tempSum + i;
				if(tempSum>mid) {
					req++;
					tempSum = i;
				} 
			}
			if(req<=B) {
				end = mid-1;
			}else {
				start=mid+1;
			}
		}
		return (int)(start%mod);
    }
	
	

}
