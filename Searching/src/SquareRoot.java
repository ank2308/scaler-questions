
public class SquareRoot {

	public static void main(String [] args) {
		SquareRoot sr = new SquareRoot();
		System.out.println(sr.sqrt(1));
	}
	
	public int sqrt(int A) {
		if(A==1) {
			return 1;
		}
		return squareRoot(A, 0, A-1, 1);
		
    }
	
	public int squareRoot(int A, int start, int end, int ans) {
		int mod = (int) (Math.pow(10, 9) + 7);
		if(start>=end) {
			if(start*start <= A) {
				return start;
			}
			return ans;
		}
		long mid = ((start%mod + end%mod)%mod)/2;
		if((mid*mid) == A) {
			return (int)mid;
		}
		if((mid*mid) > A) {			
			return squareRoot(A, start, (int)mid-1, ans);
		}
		if((mid*mid) < A) {
			ans = (int)mid;
			return squareRoot(A, (int)mid+1, end, ans);
		}
		return ans;
	}
}
